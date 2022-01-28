package com.example.shopproject.Mapper;

import com.example.shopproject.Model.DTO.Order.PostOrderDTO;
import com.example.shopproject.Model.Entity.Order;

public class OrderMapper {

    public static Order convertToOrder(PostOrderDTO postOrderDTO){
        Order order=new Order();
        order.setItems(postOrderDTO.getItems());
        return order;
    }

}