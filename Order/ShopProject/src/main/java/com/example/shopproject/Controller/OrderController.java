package com.example.shopproject.Controller;

import com.example.shopproject.Model.DTO.Order.PostOrderDTO;
import com.example.shopproject.Service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void PostOrder(@RequestBody PostOrderDTO order, @RequestParam Integer idUser){
        orderService.PostOrder(order,idUser);
    }

}