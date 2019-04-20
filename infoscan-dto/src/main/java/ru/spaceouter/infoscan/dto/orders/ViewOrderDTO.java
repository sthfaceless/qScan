package ru.spaceouter.infoscan.dto.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
