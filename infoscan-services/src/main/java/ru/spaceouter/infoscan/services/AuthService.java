package ru.spaceouter.infoscan.services;

import ru.spaceouter.infoscan.dto.view.AuthCredentialsDTO;
import ru.spaceouter.infoscan.dto.view.AuthTokenDTO;
import ru.spaceouter.infoscan.dto.auth.UserAuthDTO;
import ru.spaceouter.infoscan.exceptions.InvalidAuthenticationException;
import ru.spaceouter.infoscan.exceptions.UnauthorizedException;

/**
 * @author danil
 * @date 21.04.19
 */
public interface AuthService<T> {

    T getAuthUser(String token) throws UnauthorizedException;

    UserAuthDTO authWithCredentials(AuthCredentialsDTO authCredentialsDTO) throws InvalidAuthenticationException;

    UserAuthDTO authWithToken(AuthTokenDTO authTokenDTO) throws InvalidAuthenticationException;

    void logout(String token) throws UnauthorizedException;

}
