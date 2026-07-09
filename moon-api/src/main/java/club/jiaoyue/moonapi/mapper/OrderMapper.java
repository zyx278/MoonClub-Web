package club.jiaoyue.moonapi.mapper;


import club.jiaoyue.moonapi.entity.OrderInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface OrderMapper {


    /**
     * 查询所有订单
     */
    @Select("""
            SELECT
                id,
                title,
                category,
                cover_image AS coverImage,
                description,
                is_hot AS isHot,
                status,
                sort,
                create_time AS createTime
            FROM order_info
            WHERE status = 1
            ORDER BY sort
            """)
    List<OrderInfo> findAll();



    /**
     * 新增订单
     */
    @Insert("""
            INSERT INTO order_info
            (
                title,
                category,
                cover_image,
                description
            )
            VALUES
            (
                #{title},
                #{category},
                #{coverImage},
                #{description}
            )
            """)
    void insert(OrderInfo orderInfo);



    /**
     * 删除订单
     */
    @Delete("""
            DELETE FROM order_info
            WHERE id = #{id}
            """)
    void deleteById(Long id);

    /**
     * 修改订单
     */
    @Update("""
            UPDATE order_info
            SET
                title = #{title},
                category = #{category},
                cover_image = #{coverImage},
                description = #{description}
            WHERE id = #{id}
            """)
    void update(OrderInfo orderInfo);

    @Select("""
        SELECT
            id,
            title,
            category,
            cover_image AS coverImage,
            description,
            is_hot AS isHot,
            status,
            sort,
            create_time AS createTime
        FROM order_info
        WHERE id = #{id}
        """)
    OrderInfo findById(Long id);
}