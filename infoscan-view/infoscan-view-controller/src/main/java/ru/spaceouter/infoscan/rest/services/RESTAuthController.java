package ru.spaceouter.infoscan.rest.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spaceouter.infoscan.dto.view.AuthCredentialsDTO;
import ru.spaceouter.infoscan.dto.view.AuthTokenDTO;
import ru.spaceouter.infoscan.dto.auth.UserAuthDTO;
import ru.spaceouter.infoscan.exceptions.InvalidAuthenticationException;
import ru.spaceouter.infoscan.exceptions.UnauthorizedException;
import ru.spaceouter.infoscan.rest.AbstractRestController;
import ru.spaceouter.infoscan.services.AuthService;

/**
 * @author danil
 * @date 22.04.19
 */
@RestController
@RequestMapping("/api/auth")
public class RESTAuthController extends AbstractRestController {

    private final AuthService<UserAuthDTO> authService;

    public RESTAuthController(AuthService<UserAuthDTO> authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> authWithCredentials(@RequestBody AuthCredentialsDTO authCredentialsDTO) throws InvalidAuthenticationException {

        return found(authService.authWithCredentials(authCredentialsDTO));
    }

    @PostMapping(path = "/token")
    public ResponseEntity<?> authWithToken(@RequestBody AuthTokenDTO authTokenDTO) throws InvalidAuthenticationException {

        return found(authService.authWithToken(authTokenDTO));
    }

    @PostMapping(path = "/logout")
    public ResponseEntity<?> logout(@CookieValue(name = "token", required = false) String token)
            throws UnauthorizedException {

        authService.logout(token);
        return ok();
    }

}
