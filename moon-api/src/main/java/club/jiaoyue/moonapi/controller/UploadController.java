package club.jiaoyue.moonapi.controller;


import club.jiaoyue.moonapi.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController
@RequestMapping("/api/upload")
@CrossOrigin
public class UploadController {


    @Value("${file.upload-path}")
    private String uploadPath;



    @PostMapping
    public Result<String> upload(
            @RequestParam("file") MultipartFile file
    ) throws IOException {


        if(file.isEmpty()){

            return Result.error("文件不能为空");

        }


        // 创建目录
        File dir = new File(uploadPath + "/cover");

        if(!dir.exists()){

            dir.mkdirs();

        }


        // 获取文件后缀

        String originalName = file.getOriginalFilename();

        String suffix = originalName.substring(
                originalName.lastIndexOf(".")
        );


        // 新文件名

        String fileName =
                UUID.randomUUID()
                        +
                        suffix;


        // 保存路径

        File targetFile =
                new File(dir,fileName);


        file.transferTo(targetFile);



        // 返回访问地址

        String url =
                "/upload/cover/" + fileName;


        return Result.success(url);

    }


}