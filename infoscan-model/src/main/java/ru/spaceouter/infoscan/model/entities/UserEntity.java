package ru.spaceouter.infoscan.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author danil
 * @date 20.04.19
 */
@Data
@AllArgsConstructor
public class UserEntity {

    @Id
    private long userId;
    private String login;
    private String email;
    private String password;
    private String token;

}
