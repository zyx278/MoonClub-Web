package club.jiaoyue.moonapi.service;


import club.jiaoyue.moonapi.entity.SystemConfig;
import club.jiaoyue.moonapi.mapper.SystemConfigMapper;
import org.springframework.stereotype.Service;


@Service
public class SystemConfigService {


    private final SystemConfigMapper mapper;


    public SystemConfigService(
            SystemConfigMapper mapper
    ){

        this.mapper=mapper;

    }



    public SystemConfig getContact(){


        return mapper.findByKey(
                "contact_qrcode"
        );

    }



    public void updateContact(
            String url
    ){

        mapper.update(
                "contact_qrcode",
                url
        );

    }


}