package com.example.shopproject.Model.DTO.Order;

import com.example.shopproject.Model.Entity.Item;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostOrderDTO {
    public List<Item> items= new ArrayList<Item>();
}
