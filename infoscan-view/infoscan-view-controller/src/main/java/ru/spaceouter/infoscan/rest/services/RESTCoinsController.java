package ru.spaceouter.infoscan.rest.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spaceouter.infoscan.rest.AbstractRestController;
import ru.spaceouter.infoscan.services.CoinsService;

/**
 * @author danil
 * @date 20.04.19
 */
@RestController
@RequestMapping("/api/coins")
public class RESTCoinsController extends AbstractRestController {

    private final CoinsService coinsService;

    public RESTCoinsController(CoinsService coinsService) {
        this.coinsService = coinsService;
    }

    @GetMapping
    public ResponseEntity<?> getCoins(){

        return found(coinsService.getCoinsSize());
    }

    @GetMapping
    @RequestMapping(path = "/history")
    public ResponseEntity<?> getPaymentHistory(){

        return found(coinsService.getPaymentsHistory());
    }

    @PostMapping
    public ResponseEntity<?> createPaymentRequest(){

        coinsService.requestPayment();
        return accepted();
    }

}
