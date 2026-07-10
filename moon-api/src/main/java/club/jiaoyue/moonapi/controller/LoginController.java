package club.jiaoyue.moonapi.controller;


import club.jiaoyue.moonapi.common.Result;
import club.jiaoyue.moonapi.entity.AdminUser;
import club.jiaoyue.moonapi.service.AdminUserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/api/login")
public class LoginController {



    private final AdminUserService adminUserService;



    public LoginController(
            AdminUserService adminUserService
    ){

        this.adminUserService = adminUserService;

    }





    @PostMapping
    public Result<?> login(
            @RequestBody AdminUser user
    ){



        AdminUser result =

                adminUserService.login(
                        user.getUsername(),
                        user.getPassword()
                );




        if(result == null){


            return Result.error(
                    "账号或密码错误"
            );


        }





        Map<String,Object> data =
                new HashMap<>();


        data.put(
                "username",
                result.getUsername()
        );


        // 第一版简单token
        data.put(
                "token",
                "moon-admin-token"
        );



        return Result.success(data);



    }


}