package club.jiaoyue.moonapi.service;


import club.jiaoyue.moonapi.entity.OrderInfo;
import club.jiaoyue.moonapi.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {


    private final OrderMapper orderMapper;


    public OrderService(OrderMapper orderMapper) {

        this.orderMapper = orderMapper;

    }


    /**
     * 查询所有订单
     */
    public List<OrderInfo> list() {

        return orderMapper.findAll();

    }


    /**
     * 新增订单
     */
    public void add(OrderInfo orderInfo) {

        orderMapper.insert(orderInfo);

    }


    /**
     * 删除订单
     */
    public void delete(Long id) {

        orderMapper.deleteById(id);

    }

    /**
     * 修改订单
     */
    public void update(OrderInfo orderInfo){

        orderMapper.update(orderInfo);

    }

    /**
     * 根据id查询订单
     */
    public OrderInfo findById(Long id){

        return orderMapper.findById(id);

    }

}