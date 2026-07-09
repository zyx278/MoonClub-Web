package club.jiaoyue.moonapi.entity;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class OrderInfo {


    private Long id;


    private String title;


    private String category;


    private String coverImage;


    private String description;


    private Integer isHot;


    private Integer status;


    private Integer sort;


    private LocalDateTime createTime;


}