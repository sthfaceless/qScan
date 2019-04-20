package ru.spaceouter.infoscan.services.implementations;

import org.springframework.stereotype.Service;
import ru.spaceouter.infoscan.dto.orders.FullOrderDTO;
import ru.spaceouter.infoscan.dto.orders.ViewOrderDTO;
import ru.spaceouter.infoscan.services.OrdersService;

import java.util.List;

/**
 * @author danil
 * @date 20.04.19
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Override
    public List<ViewOrderDTO> getOrders() {
        return null;
    }

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
