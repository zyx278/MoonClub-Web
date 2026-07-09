package club.jiaoyue.moonapi.controller;


import club.jiaoyue.moonapi.entity.OrderType;
import club.jiaoyue.moonapi.service.OrderTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order-types")
@CrossOrigin
public class OrderTypeController {


    private final OrderTypeService service;


    public OrderTypeController(OrderTypeService service){

        this.service = service;

    }


    @GetMapping
    public List<OrderType> list(){

        return service.findAll();

    }


    @PostMapping
    public void add(
            @RequestBody OrderType orderType
    ){

        service.save(orderType);

    }


    @PutMapping
    public void update(
            @RequestBody OrderType orderType
    ){

        service.update(orderType);

    }


    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){

        service.delete(id);

    }

}