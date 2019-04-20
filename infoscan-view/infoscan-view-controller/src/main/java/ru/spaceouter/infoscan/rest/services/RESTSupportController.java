package ru.spaceouter.infoscan.rest.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spaceouter.infoscan.dto.support.CreateQuestionDTO;
import ru.spaceouter.infoscan.rest.AbstractRestController;
import ru.spaceouter.infoscan.services.SupportService;

/**
 * @author danil
 * @date 20.04.19
 */
@RestController
@RequestMapping("/api/support")
public class RESTSupportController extends AbstractRestController {

    private final SupportService supportService;

    public RESTSupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody CreateQuestionDTO createQuestionDTO){

        supportService.createQuestion(createQuestionDTO);
        return created();
    }


}
