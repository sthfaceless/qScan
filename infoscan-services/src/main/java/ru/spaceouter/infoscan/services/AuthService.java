package ru.spaceouter.infoscan.services;

import ru.spaceouter.infoscan.dto.auth.UserAuthDTO;

/**
 * @author danil
 * @date 21.04.19
 */
public interface AuthService<T> {

    T getAuthUser(String token);

}
