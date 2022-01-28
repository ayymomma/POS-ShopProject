package com.example.shopproject.Model.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {

    @MongoId
    private ObjectId id;
    private Date date = new Date();
    private List<Item> items= new ArrayList<Item>();

}