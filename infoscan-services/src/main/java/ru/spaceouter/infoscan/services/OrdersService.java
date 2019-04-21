package ru.spaceouter.infoscan.services;

import ru.spaceouter.infoscan.dto.orders.FullOrderDTO;
import ru.spaceouter.infoscan.dto.orders.ViewOrderDTO;

import java.util.List;

/**
 * @author danil
 * @date 20.04.19
 */
public interface OrdersService {

    List<ViewOrderDTO> getOrders(long userId);

    FullOrderDTO getOrder(long userId, long orderId);

    void createOrder(long userId, FullOrderDTO fullOrderDTO);

    void updateOrder(long userId , FullOrderDTO fullOrderDTO);

}
