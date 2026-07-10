package club.jiaoyue.moonapi.mapper;


import club.jiaoyue.moonapi.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CategoryMapper {


    @Select("""
        SELECT
            id,
            name,
            sort,
            status,
            create_time AS createTime
        FROM category
        ORDER BY sort
    """)
    List<Category> findAll();



    @Insert("""
        INSERT INTO category
        (
            name,
            sort,
            status
        )
        VALUES
        (
            #{name},
            #{sort},
            #{status}
        )
    """)
    void insert(Category category);




    @Update("""
        UPDATE category
        SET
            name=#{name},
            sort=#{sort},
            status=#{status}
        WHERE id=#{id}
    """)
    void update(Category category);




    @Delete("""
        DELETE FROM category
        WHERE id=#{id}
    """)
    void delete(Long id);


}