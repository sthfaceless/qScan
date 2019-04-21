package ru.spaceouter.infoscan.dto.auth;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author danil
 * @date 21.04.19
 */
@ToString
@AllArgsConstructor
public enum Role {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    final String role;

}
