package ru.spaceouter.infoscan.rest.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spaceouter.infoscan.dto.auth.UserAuthDTO;
import ru.spaceouter.infoscan.dto.orders.FullOrderDTO;
import ru.spaceouter.infoscan.exceptions.UnauthorizedException;
import ru.spaceouter.infoscan.rest.RestControllerWithAuthorization;
import ru.spaceouter.infoscan.services.AuthService;
import ru.spaceouter.infoscan.services.OrdersService;

/**
 * @author danil
 * @date 20.04.19
 */
@RestController
@RequestMapping("/api/orders")
public class RESTOrdersController extends RestControllerWithAuthorization<UserAuthDTO> {

    private final OrdersService ordersService;

    public RESTOrdersController(AuthService<UserAuthDTO> authService,
                                OrdersService ordersService) {
        super(authService);
        this.ordersService = ordersService;
    }

    @GetMapping
    public ResponseEntity<?> getOrders(@CookieValue(name = "token", required = false) String token)
            throws UnauthorizedException {

        return found(ordersService.getOrders(
                getAuthDataByToken(token).getUserId()));
    }

    @GetMapping
    @RequestMapping(path = "{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") String id,
                                      @CookieValue(name = "token", required = false) String token)
            throws UnauthorizedException{

        return found(ordersService.getOrder(
                getAuthDataByToken(token).getUserId(),
                Integer.parseInt(id)));
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody FullOrderDTO fullOrderDTO,
                                         @CookieValue(name = "token", required = false) String token)
            throws UnauthorizedException{

        ordersService.createOrder(
                getAuthDataByToken(token).getUserId(),
                fullOrderDTO);
        return created();
    }

    @PutMapping
    public ResponseEntity<?> updateOrder(@RequestBody FullOrderDTO fullOrderDTO,
                                         @CookieValue(name = "token", required = false) String token)
            throws UnauthorizedException{

        ordersService.updateOrder(
                getAuthDataByToken(token).getUserId(),
                fullOrderDTO);

        return accepted();
    }

}
