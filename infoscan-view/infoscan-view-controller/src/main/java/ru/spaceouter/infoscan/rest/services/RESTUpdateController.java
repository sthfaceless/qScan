package ru.spaceouter.infoscan.rest.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spaceouter.infoscan.rest.AbstractRestController;

/**
 * @author danil
 * @date 20.04.19
 */
@RestController
@RequestMapping("/api/update")
public class RESTUpdateController extends AbstractRestController {

    @PostMapping
    @RequestMapping(path = "/email")
    public ResponseEntity<?> updateEmail(){

        return created();
    }

    @PutMapping
    @RequestMapping(path = "/email/{uuid}")
    public ResponseEntity<?> updateEmailConfirm(@PathVariable("uuid") String uuid){

        return accepted();
    }

    @PutMapping
    @RequestMapping(path = "/pass")
    public ResponseEntity<?> updatePassword(){

        return accepted();
    }

}
