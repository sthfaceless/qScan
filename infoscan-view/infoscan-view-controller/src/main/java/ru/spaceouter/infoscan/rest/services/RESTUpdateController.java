package ru.spaceouter.infoscan.rest.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spaceouter.infoscan.dto.update.UpdateEmailDTO;
import ru.spaceouter.infoscan.dto.update.UpdatePasswordDTO;
import ru.spaceouter.infoscan.rest.AbstractRestController;
import ru.spaceouter.infoscan.services.UpdateService;

/**
 * @author danil
 * @date 20.04.19
 */
@RestController
@RequestMapping("/api/update")
public class RESTUpdateController extends AbstractRestController {

    private final UpdateService updateService;

    public RESTUpdateController(UpdateService updateService) {
        this.updateService = updateService;
    }

    @PostMapping
    @RequestMapping(path = "/email")
    public ResponseEntity<?> updateEmail(@RequestBody UpdateEmailDTO updateEmailDTO){

        updateService.updateEmail(updateEmailDTO.getEmail());
        return created();
    }

    @PutMapping
    @RequestMapping(path = "/email/{uuid}")
    public ResponseEntity<?> updateEmailConfirm(@PathVariable("uuid") String uuid){

        updateService.confirmEmailUpdating(uuid);
        return accepted();
    }

    @PutMapping
    @RequestMapping(path = "/pass")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordDTO updatePasswordDTO){

        updateService.updatePassword(updatePasswordDTO.getPassword());
        return accepted();
    }

}
