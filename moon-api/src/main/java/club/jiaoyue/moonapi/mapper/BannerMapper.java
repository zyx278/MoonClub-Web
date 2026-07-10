package club.jiaoyue.moonapi.mapper;


import club.jiaoyue.moonapi.entity.Banner;
import org.apache.ibatis.annotations.*;

import java.util.List;



@Mapper
public interface BannerMapper {



    /**
     * 查询所有启用Banner
     */
    @Select("""
        SELECT
            id,
            title,
            image,
            sort,
            status,
            create_time AS createTime
        FROM banner
        WHERE status = 1
        ORDER BY sort
    """)
    List<Banner> findAll();





    /**
     * 新增
     */
    @Insert("""
        INSERT INTO banner
        (
            title,
            image,
            sort,
            status
        )
        VALUES
        (
            #{title},
            #{image},
            #{sort},
            #{status}
        )
    """)
    void insert(Banner banner);






    /**
     * 修改
     */
    @Update("""
        UPDATE banner
        SET
            title=#{title},
            image=#{image},
            sort=#{sort},
            status=#{status}
        WHERE id=#{id}
    """)
    void update(Banner banner);






    /**
     * 删除
     */
    @Delete("""
        DELETE FROM banner
        WHERE id=#{id}
    """)
    void delete(Long id);



}