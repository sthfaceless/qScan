package ru.spaceouter.infoscan.rest.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spaceouter.infoscan.dto.auth.AuthDTO;
import ru.spaceouter.infoscan.dto.auth.CreateUserDTO;
import ru.spaceouter.infoscan.dto.auth.RestoreDTO;
import ru.spaceouter.infoscan.model.AuthDAO;
import ru.spaceouter.infoscan.rest.AbstractRestController;
import ru.spaceouter.infoscan.services.AuthService;

/**
 * @author danil
 * @date 20.04.19
 */
@RestController
@RequestMapping("/api/auth")
public class RESTAuthController extends AbstractRestController {

    private final AuthService authService;

    public RESTAuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody AuthDTO authDTO){

        authService.auth(authDTO);

        return ok();
    }

    @PostMapping
    @RequestMapping(path = "/reg")
    public ResponseEntity<?> reg(@RequestBody CreateUserDTO createUserDTO){

        authService.createUser(createUserDTO);
        return created();
    }

    @PutMapping
    @RequestMapping(path = "/reg/{uuid}")
    public ResponseEntity<?> regConfirm(@PathVariable("uuid") String uuid){

        authService.activateUser(uuid);
        return accepted();
    }

    @PostMapping
    @RequestMapping(path = "/restore")
    public ResponseEntity<?> restore(@RequestBody RestoreDTO restoreDTO){

        authService.restore(restoreDTO);
        return created();
    }

    @PutMapping
    @RequestMapping(path = "/restore/{uuid}")
    public ResponseEntity<?> restoreConfirm(@PathVariable("uuid") String uuid){

        authService.confirmRestore(uuid);
        return accepted();
    }

    @PostMapping
    @RequestMapping(path = "/logout")
    public ResponseEntity<?> logout(){

        authService.logout();
        return ok();
    }

}
