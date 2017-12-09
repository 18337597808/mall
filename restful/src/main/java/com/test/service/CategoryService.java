package com.test.service;

import com.test.dao.CategoryDao;
import com.test.entity.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryDao cd;
    public List<Category> findAllCategoryForPortal(){
        return  cd.findAllCategoryForPortal();
    }
}
