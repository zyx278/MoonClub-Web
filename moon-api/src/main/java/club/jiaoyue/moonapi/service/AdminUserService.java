package club.jiaoyue.moonapi.service;


import club.jiaoyue.moonapi.entity.AdminUser;
import club.jiaoyue.moonapi.mapper.AdminUserMapper;
import org.springframework.stereotype.Service;



@Service
public class AdminUserService {



    private final AdminUserMapper adminUserMapper;



    public AdminUserService(
            AdminUserMapper adminUserMapper
    ){

        this.adminUserMapper = adminUserMapper;

    }





    public AdminUser login(
            String username,
            String password
    ){

        return adminUserMapper.login(
                username,
                password
        );

    }



}