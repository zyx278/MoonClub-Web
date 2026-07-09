package club.jiaoyue.moonapi.mapper;


import club.jiaoyue.moonapi.entity.OrderType;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface OrderTypeMapper {


    @Select("""
            select *
            from order_type
            order by sort asc
            """)
    List<OrderType> findAll();



    @Insert("""
            insert into order_type
            (
                name,
                sort,
                status
            )
            values
            (
                #{name},
                #{sort},
                #{status}
            )
            """)
    void insert(OrderType orderType);



    @Update("""
            update order_type
            set
                name=#{name},
                sort=#{sort},
                status=#{status}
            where id=#{id}
            """)
    void update(OrderType orderType);



    @Delete("""
            delete from order_type
            where id=#{id}
            """)
    void delete(Long id);

}
