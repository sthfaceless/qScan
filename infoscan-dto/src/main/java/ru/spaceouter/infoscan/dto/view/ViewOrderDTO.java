package ru.spaceouter.infoscan.dto.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.spaceouter.infoscan.dto.orders.OrderStatus;

import java.util.Date;

/**
 * @author danil
 * @date 20.04.19
 */
@Getter
@AllArgsConstructor
public class ViewOrderDTO {

    private final long id;
    private final String username;
    private final Date date;
    private final OrderStatus orderStatus;

}
