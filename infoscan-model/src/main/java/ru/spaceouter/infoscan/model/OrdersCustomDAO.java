package ru.spaceouter.infoscan.model;

import ru.spaceouter.infoscan.dto.model.OrderModelDTO;
import ru.spaceouter.infoscan.dto.view.orders.CreateOrderDTO;
import ru.spaceouter.infoscan.dto.view.orders.FullOrderDTO;
import ru.spaceouter.infoscan.dto.view.orders.SocialNetworkDTO;
import ru.spaceouter.infoscan.dto.view.orders.ViewOrderDTO;
import ru.spaceouter.infoscan.exceptions.NotExistException;

import java.util.List;

/**
 * @author danil
 * @date 23.04.19
 */
public interface OrdersCustomDAO  {


    List<ViewOrderDTO> getOrdersByUser(long userId, int start, int max);

    long getOrderInformationIdByOrder(long orderId);

    FullOrderDTO getFullOrder(long orderId, long userId);

    List<SocialNetworkDTO> getSocialNetwork(long orderId, long userId);

    long saveOrder(long userId, CreateOrderDTO createOrderDTO);

    boolean updateOrder(long orderId, String fieldName, String value, long userId);

    long updateOrderSocialNetworks(SocialNetworkDTO socialNetworkDTO, long userId) throws NotExistException;
}
