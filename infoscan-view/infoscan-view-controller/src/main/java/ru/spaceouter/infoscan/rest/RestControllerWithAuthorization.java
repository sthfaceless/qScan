package ru.spaceouter.infoscan.rest;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.spaceouter.infoscan.exceptions.UnauthorizedException;
import ru.spaceouter.infoscan.services.AuthService;

/**
 * @author danil
 * @date 21.04.19
 */
@Component
public class RestControllerWithAuthorization<T> extends AbstractRestController {

    private final AuthService<T> authService;

    public RestControllerWithAuthorization(AuthService<T> authService) {
        this.authService = authService;
    }

    protected T getAuthDataByToken(String token) throws UnauthorizedException{

        if(StringUtils.isEmpty(token))
            throw new UnauthorizedException();

        return authService.getAuthUser(token);
    }

}
