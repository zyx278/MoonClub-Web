package club.jiaoyue.moonapi.service;


import club.jiaoyue.moonapi.entity.OrderType;
import club.jiaoyue.moonapi.mapper.OrderTypeMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderTypeService {


    private final OrderTypeMapper mapper;


    public OrderTypeService(OrderTypeMapper mapper){

        this.mapper = mapper;

    }


    public List<OrderType> findAll(){

        return mapper.findAll();

    }


    public void save(OrderType orderType){

        mapper.insert(orderType);

    }


    public void update(OrderType orderType){

        mapper.update(orderType);

    }


    public void delete(Long id){

        mapper.delete(id);

    }

}