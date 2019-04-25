package ru.spaceouter.infoscan.services.transactional.implementations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.dto.view.orders.*;
import ru.spaceouter.infoscan.exceptions.NotExistException;
import ru.spaceouter.infoscan.exceptions.WrongArgumentsException;
import ru.spaceouter.infoscan.model.OrdersCustomDAO;
import ru.spaceouter.infoscan.model.ProxyDAO;
import ru.spaceouter.infoscan.services.ParametersValidator;
import ru.spaceouter.infoscan.services.listeners.OrdersListener;
import ru.spaceouter.infoscan.services.transactional.OrdersService;

import java.util.List;

/**
 * @author danil
 * @date 20.04.19
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrdersServiceImpl implements OrdersService {

    private final OrdersCustomDAO ordersCustomDAO;
    private final ProxyDAO proxyDAO;

    private final OrdersListener ordersListener;

    private final ParametersValidator parametersValidator;

    private final int maxOrdersSize;

    public OrdersServiceImpl(OrdersCustomDAO ordersCustomDAO,
                             ProxyDAO proxyDAO,
                             OrdersListener ordersListener,
                             ParametersValidator parametersValidator,
                             @Value("${orders.view.size}") Integer maxOrdersSize) {
        this.ordersCustomDAO = ordersCustomDAO;
        this.proxyDAO = proxyDAO;
        this.ordersListener = ordersListener;
        this.parametersValidator = parametersValidator;
        this.maxOrdersSize = maxOrdersSize;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ViewOrderDTO> getOrders(long userId, String start) throws WrongArgumentsException {

        int startValue = 0;
        if(start != null && parametersValidator.validateNumber(start)) {
            startValue = Integer.parseInt(start);
        }

        return ordersCustomDAO.getOrdersByUser(userId, startValue, maxOrdersSize);
    }

    @Transactional(readOnly = true)
    @Override
    public FullOrderDTO getOrder(String orderId, long userId) throws WrongArgumentsException {

        if(!parametersValidator.validateNumber(orderId))
            throw new WrongArgumentsException();

        return ordersCustomDAO.getFullOrder(Long.parseLong(orderId), userId);
    }

    @Override
    public void createOrder(long userId, CreateOrderDTO createOrderDTO) {

        long orderId = ordersCustomDAO.saveOrder(userId, createOrderDTO);
        ordersListener.ordersCreated(orderId);
    }

    @Override
    public void updateOrder(long userId, UpdateOrderDTO update) {

        if(update.getField() == OrderField.SOCIAL_NETWORKS) return;

        ordersCustomDAO.updateOrder(update.getOrderId(),
                update.getField().toString(), update.getValue(),
                userId);

        ordersListener.orderUpdated(update.getOrderId(), update.getField());
    }

    @Override
    public void updateSocialNetwork(SocialNetworkDTO socialNetworkDTO, long userId) throws NotExistException {

        long orderId = ordersCustomDAO.updateOrderSocialNetworks(socialNetworkDTO, userId);
        ordersListener.orderUpdated(orderId, OrderField.SOCIAL_NETWORKS);
    }
}
