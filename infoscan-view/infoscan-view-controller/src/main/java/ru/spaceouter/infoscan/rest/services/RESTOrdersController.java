package ru.spaceouter.infoscan.rest.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spaceouter.infoscan.dto.orders.FullOrderDTO;
import ru.spaceouter.infoscan.rest.AbstractRestController;
import ru.spaceouter.infoscan.services.OrdersService;

/**
 * @author danil
 * @date 20.04.19
 */
@RestController
@RequestMapping("/api/orders")
public class RESTOrdersController extends AbstractRestController {

    private final OrdersService ordersService;

    public RESTOrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public ResponseEntity<?> getOrders(){

        return found(ordersService.getOrders());
    }

    @GetMapping
    @RequestMapping(path = "{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") String id){

        return found(ordersService.getOrder(Integer.parseInt(id)));
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody FullOrderDTO fullOrderDTO){

        ordersService.createOrder(fullOrderDTO);
        return created();
    }

    @PutMapping
    public ResponseEntity<?> updateOrder(@RequestBody FullOrderDTO fullOrderDTO){

        ordersService.updateOrder(fullOrderDTO);
        return accepted();
    }

}
