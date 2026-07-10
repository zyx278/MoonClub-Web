package club.jiaoyue.moonapi.controller;


import club.jiaoyue.moonapi.common.Result;
import club.jiaoyue.moonapi.entity.Banner;
import club.jiaoyue.moonapi.service.BannerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/banner")
public class BannerController {


    private final BannerService bannerService;



    public BannerController(
            BannerService bannerService
    ){

        this.bannerService=bannerService;

    }





    @GetMapping
    public Result<List<Banner>> list(){


        return Result.success(
                bannerService.list()
        );


    }






    @PostMapping
    public Result<String> add(
            @RequestBody Banner banner
    ){


        bannerService.add(banner);


        return Result.success(
                "新增成功"
        );


    }






    @PutMapping
    public Result<String> update(
            @RequestBody Banner banner
    ){


        bannerService.update(banner);


        return Result.success(
                "修改成功"
        );


    }






    @DeleteMapping("/{id}")
    public Result<String> delete(
            @PathVariable Long id
    ){


        bannerService.delete(id);


        return Result.success(
                "删除成功"
        );


    }


}