package com.example.shopproject.Service;

import com.example.shopproject.Mapper.OrderMapper;
import com.example.shopproject.Model.DTO.Order.PostOrderDTO;
import com.example.shopproject.Model.Entity.Item;
import com.example.shopproject.Model.Entity.Order;
import com.mongodb.client.MongoClients;
import org.apache.coyote.Request;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.List;

@Service
public class OrderService {

    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(),
            "pos_orders"));

    public void PostOrder(PostOrderDTO postOrderDTO, Long idUser) {
        Order order = OrderMapper.convertToOrder(postOrderDTO);
        for (Item item :
                order.getItems()
             ) {

            RestTemplate restTemplate = new RestTemplate();

            String uri = "http://localhost:8080/api/bookcollection/books/" + item.getIsbn();
            String uri2 = "http://localhost:8080/api/bookcollection/books/getStock/" + item.getIsbn();
            String book = restTemplate.getForObject(uri, String.class);
            Integer stock = restTemplate.getForObject(uri2, Integer.class);

            if(book !=  null)
            {
                if(stock != null)
                    if(stock >= item.getAmount())
                    {
                        stock = stock - item.getAmount();
                        restTemplate.postForObject("http://localhost:8080/api/bookcollection/books/updateStock/" + item.getIsbn() + "/" + stock, "", String.class);
                        continue;
                    }
            }
            List<Item> list = order.getItems();
            list.remove(item);
            order.setItems(list);
        }
        mongoOps.insert(order,"Client."+idUser);
    }
    public List<Order> GetOrders(Long idUser){
        return mongoOps.findAll(Order.class, "Client."+idUser);
    }
    public void DeleteAllOrders(Integer idUser){
        mongoOps.dropCollection("Client."+idUser);
    }
}