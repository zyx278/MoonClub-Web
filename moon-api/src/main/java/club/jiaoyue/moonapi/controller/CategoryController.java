package club.jiaoyue.moonapi.controller;


import club.jiaoyue.moonapi.common.Result;
import club.jiaoyue.moonapi.entity.Category;
import club.jiaoyue.moonapi.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/category")
public class CategoryController {


    private final CategoryService categoryService;



    public CategoryController(CategoryService categoryService){

        this.categoryService=categoryService;

    }



    @GetMapping
    public Result<List<Category>> list(){

        return Result.success(
                categoryService.list()
        );

    }




    @PostMapping
    public Result<String> add(
            @RequestBody Category category
    ){

        categoryService.add(category);

        return Result.success("新增成功");

    }




    @PutMapping
    public Result<String> update(
            @RequestBody Category category
    ){

        categoryService.update(category);

        return Result.success("修改成功");

    }




    @DeleteMapping("/{id}")
    public Result<String> delete(
            @PathVariable Long id
    ){

        categoryService.delete(id);

        return Result.success("删除成功");

    }



}