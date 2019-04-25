package ru.spaceouter.infoscan.dto.view.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author danil
 * @date 22.04.19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenDTO {

    private String token;

}
