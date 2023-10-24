package com.lltech.llmall;

import com.lltech.llmall.dao.CategoryMapper;
import com.lltech.llmall.entity.CategoryVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ApiApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void contextLoads() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        for (CategoryVO c1 : categoryVOS) {
            System.out.println(c1.toString());
            for (CategoryVO c2 : categoryVOS) {
                System.out.println("\t" + c2.toString());
                for (CategoryVO c3 : categoryVOS) {
                    System.out.println("\t\t" + c3.toString());
                }
            }
        }
    }

}
