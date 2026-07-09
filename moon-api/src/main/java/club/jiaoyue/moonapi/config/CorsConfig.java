package club.jiaoyue.moonapi.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {


        registry.addMapping("/**")

                //允许前端地址
                .allowedOrigins(
                        "http://localhost:5173",
                        "http://localhost:5174"
                )

                //允许请求方法
                .allowedMethods(
                        "GET",
                        "POST",
                        "PUT",
                        "DELETE",
                        "OPTIONS"
                )

                //允许请求头
                .allowedHeaders("*")

                //允许携带cookie
                .allowCredentials(true);


    }


}