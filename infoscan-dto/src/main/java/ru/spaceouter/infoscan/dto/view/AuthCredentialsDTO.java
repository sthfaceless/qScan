package ru.spaceouter.infoscan.dto.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author danil
 * @date 20.04.19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthCredentialsDTO {

    private String login;
    private String password;

}
