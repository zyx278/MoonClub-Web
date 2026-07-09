package club.jiaoyue.moonapi.controller;

import org.springframework.web.bind.annotation.PutMapping;
import club.jiaoyue.moonapi.common.Result;
import club.jiaoyue.moonapi.entity.OrderInfo;
import club.jiaoyue.moonapi.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {


    private final OrderService orderService;


    public OrderController(OrderService orderService){

        this.orderService = orderService;

    }



    /**
     * 查询订单
     */
    @GetMapping
    public Result<List<OrderInfo>> list(){

        return Result.success(
                orderService.list()
        );

    }



    /**
     * 新增订单
     */
    @PostMapping
    public Result<String> add(
            @RequestBody OrderInfo orderInfo
    ){

        orderService.add(orderInfo);

        return Result.success("新增成功");

    }

    @DeleteMapping("/{id}")
    public Result<String> delete(
            @PathVariable Long id
    ){

        orderService.delete(id);

        return Result.success("删除成功");

    }

    @PutMapping
    public Result<String> update(
            @RequestBody OrderInfo orderInfo
    ){

        orderService.update(orderInfo);

        return Result.success("修改成功");

    }

    /**
     * 查询单个订单
     */
    @GetMapping("/{id}")
    public Result<OrderInfo> detail(
            @PathVariable Long id
    ){

        return Result.success(
                orderService.findById(id)
        );

    }

}