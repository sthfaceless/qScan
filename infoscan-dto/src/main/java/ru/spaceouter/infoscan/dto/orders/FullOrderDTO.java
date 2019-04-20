package ru.spaceouter.infoscan.dto.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author danil
 * @date 20.04.19
 */
@Getter
@AllArgsConstructor
public class FullOrderDTO {

    private final long id;

    private final String firstName;
    private final String lastName;
    private final String patronymic;

    private final String ip;
    private final String phone;
    private final String picture;

    private final String pseudoName;
    private final String email;

    private List<String> socialNetworks;

    private String alternate;

}
