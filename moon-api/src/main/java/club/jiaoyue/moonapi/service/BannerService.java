package club.jiaoyue.moonapi.service;


import club.jiaoyue.moonapi.entity.Banner;
import club.jiaoyue.moonapi.mapper.BannerMapper;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class BannerService {


    private final BannerMapper bannerMapper;



    public BannerService(
            BannerMapper bannerMapper
    ){

        this.bannerMapper = bannerMapper;

    }




    public List<Banner> list(){

        return bannerMapper.findAll();

    }




    public void add(Banner banner){

        bannerMapper.insert(banner);

    }





    public void update(Banner banner){

        bannerMapper.update(banner);

    }





    public void delete(Long id){

        bannerMapper.delete(id);

    }


}