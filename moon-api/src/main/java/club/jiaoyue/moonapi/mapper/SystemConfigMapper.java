package club.jiaoyue.moonapi.mapper;


import club.jiaoyue.moonapi.entity.SystemConfig;
import org.apache.ibatis.annotations.*;


@Mapper
public interface SystemConfigMapper {


    @Select("""
        SELECT
        id,
        config_key AS configKey,
        config_value AS configValue
        FROM system_config
        WHERE config_key=#{key}
    """)
    SystemConfig findByKey(String key);



    @Update("""
        UPDATE system_config
        SET config_value=#{value}
        WHERE config_key=#{key}
    """)
    void update(
            String key,
            String value
    );


}