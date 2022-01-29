package com.example.shopproject.Controller;

import com.example.shopproject.Model.DTO.Order.PostOrderDTO;
import com.example.shopproject.Model.Entity.Order;
import com.example.shopproject.Model.Entity.User;
import com.example.shopproject.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

    public final OrderService orderService;
    RestTemplate restTemplate;
    String tokenUrl ;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        restTemplate = new RestTemplate();
        tokenUrl = "http://localhost:8282/api/user/token";

    }

    @PostMapping(value = "/postorder")
    public ResponseEntity<String> PostOrder(@RequestBody PostOrderDTO order, @RequestParam String token){
        try {
            var user = restTemplate.getForObject(tokenUrl + "?token=" + token, User.class);
            assert user != null;
            orderService.PostOrder(order, user.getId());
            return ResponseEntity.ok("added order successfully");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/getorders")
    public ResponseEntity<List<Order>> GetOrders(@RequestParam String token){
        try {
            var user = restTemplate.getForObject(tokenUrl + "?token=" + token, User.class);
            assert user != null;
            var orders= orderService.GetOrders(user.getId());
            return ResponseEntity.ok(orders);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}