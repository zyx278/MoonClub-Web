package club.jiaoyue.moonapi.mapper;


import club.jiaoyue.moonapi.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface AdminUserMapper {



    @Select("""
        SELECT
            id,
            username,
            password,
            create_time AS createTime
        FROM admin_user
        WHERE username = #{username}
        AND password = #{password}
    """)
    AdminUser login(
            String username,
            String password
    );


}