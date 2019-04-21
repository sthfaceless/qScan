package ru.spaceouter.infoscan.rest.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spaceouter.infoscan.dto.auth.AuthDTO;
import ru.spaceouter.infoscan.dto.auth.CreateUserDTO;
import ru.spaceouter.infoscan.dto.auth.RestoreDTO;
import ru.spaceouter.infoscan.dto.auth.UserAuthDTO;
import ru.spaceouter.infoscan.exceptions.UnauthorizedException;
import ru.spaceouter.infoscan.rest.AbstractRestController;
import ru.spaceouter.infoscan.rest.RestControllerWithAuthorization;
import ru.spaceouter.infoscan.services.AuthService;
import ru.spaceouter.infoscan.services.UserService;

/**
 * @author danil
 * @date 20.04.19
 */
@RestController
@RequestMapping("/api/auth")
public class RESTUserController extends RestControllerWithAuthorization<UserAuthDTO> {

    private final UserService userService;

    public RESTUserController(AuthService<UserAuthDTO> authService,
                              UserService userService) {
        super(authService);
        this.userService = userService;
    }

    @PostMapping
    @RequestMapping(path = "/reg")
    public ResponseEntity<?> reg(@RequestBody CreateUserDTO createUserDTO){

        userService.createUser(createUserDTO);
        return created();
    }

    @PutMapping
    @RequestMapping(path = "/reg/{uuid}")
    public ResponseEntity<?> regConfirm(@PathVariable("uuid") String uuid){

        userService.activateUser(uuid);
        return accepted();
    }

    @PostMapping
    @RequestMapping(path = "/restore")
    public ResponseEntity<?> restore(@RequestBody RestoreDTO restoreDTO){

        userService.restore(restoreDTO);
        return created();
    }

    @PutMapping
    @RequestMapping(path = "/restore/{uuid}")
    public ResponseEntity<?> restoreConfirm(@PathVariable("uuid") String uuid){

        userService.confirmRestore(uuid);
        return accepted();
    }

    @PostMapping
    @RequestMapping(path = "/logout")
    public ResponseEntity<?> logout(@CookieValue(name = "token", required = false) String token)
            throws UnauthorizedException {

        userService.logout(
                getAuthDataByToken(token).getUserId());
        return ok();
    }

}
