package ru.spaceouter.infoscan.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author danil
 * @date 20.04.19
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {

    private String login;
    private String email;
    private String password;

}
