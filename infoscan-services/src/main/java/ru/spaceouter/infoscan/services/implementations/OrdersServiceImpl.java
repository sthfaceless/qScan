package ru.spaceouter.infoscan.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.dto.orders.FullOrderDTO;
import ru.spaceouter.infoscan.dto.orders.ViewOrderDTO;
import ru.spaceouter.infoscan.services.OrdersService;

import java.util.List;

/**
 * @author danil
 * @date 20.04.19
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrdersServiceImpl implements OrdersService {

    @Transactional(readOnly = true)
    @Override
    public List<ViewOrderDTO> getOrders() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public FullOrderDTO getOrder(long id) {
        return null;
    }

    @Override
    public void createOrder(FullOrderDTO fullOrderDTO) {

    }

    @Override
    public void updateOrder(FullOrderDTO fullOrderDTO) {

    }
}
