package ru.spaceouter.infoscan.dto.orders;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author danil
 * @date 20.04.19
 */
@ToString
@AllArgsConstructor
public enum OrderStatus {

    ACCEPTED("ACCEPTED"),
    PROCESSED("PROCESSED"),
    FINISHED("FINISHED");

    private final String name;

}
