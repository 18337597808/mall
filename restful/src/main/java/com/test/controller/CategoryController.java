package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.entity.Category;
import com.test.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//@RestController 相当于RequestBody 和@Controller的合用
@RestController
public class CategoryController {
    @Resource
    private CategoryService cs;
    @RequestMapping("findAllCategoryForPortal")
    public String findAllCategoryForPortal() {
        List<Category> data = cs.findAllCategoryForPortal();
        //JSON.toJSONString则是将List转化为Json字符串。
        String s = JSON.toJSONString(data);
        String json = "category.getDataService({\"data\":"+s+"})";
        return  json;
    }
}
