package club.jiaoyue.moonapi.controller;


import club.jiaoyue.moonapi.common.Result;
import club.jiaoyue.moonapi.entity.SystemConfig;
import club.jiaoyue.moonapi.service.SystemConfigService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/config")
public class SystemConfigController {


    private final SystemConfigService service;


    public SystemConfigController(
            SystemConfigService service
    ){

        this.service=service;

    }



    @GetMapping("/contact")
    public Result<SystemConfig> contact(){

        return Result.success(
                service.getContact()
        );

    }



    @PutMapping("/contact")
    public Result<String> update(
            @RequestParam String url
    ){

        service.updateContact(url);


        return Result.success(
                "保存成功"
        );

    }

}