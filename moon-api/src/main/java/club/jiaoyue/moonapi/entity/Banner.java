package club.jiaoyue.moonapi.entity;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Banner {


    private Long id;


    private String title;


    private String image;


    private Integer sort;


    private Integer status;


    private LocalDateTime createTime;


}