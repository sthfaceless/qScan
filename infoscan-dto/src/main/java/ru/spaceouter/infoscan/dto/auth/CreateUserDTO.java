package ru.spaceouter.infoscan.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author danil
 * @date 20.04.19
 */
@Getter
@AllArgsConstructor
public class CreateUserDTO {

    private final String login;
    private final String email;
    private final String password;

}
