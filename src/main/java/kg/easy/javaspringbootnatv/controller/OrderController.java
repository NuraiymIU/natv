package kg.easy.javaspringbootnatv.controller;

import kg.easy.javaspringbootnatv.models.json.OrderResultSet;
import kg.easy.javaspringbootnatv.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public OrderResultSet saveOrder(@RequestBody OrderResultSet orderResultSet) {
        return orderService.saveOrder(orderResultSet);
    }

}
