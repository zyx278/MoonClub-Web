package club.jiaoyue.moonapi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("club.jiaoyue.moonapi.mapper")
public class MoonApiApplication {


    public static void main(String[] args) {

        SpringApplication.run(MoonApiApplication.class, args);

    }

}