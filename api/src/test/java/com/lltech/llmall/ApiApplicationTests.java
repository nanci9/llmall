package com.lltech.llmall;

import com.lltech.llmall.dao.CategoryMapper;
import com.lltech.llmall.dao.ProductCommentsMapper;
import com.lltech.llmall.dao.ProductMapper;
import com.lltech.llmall.entity.CategoryVO;
import com.lltech.llmall.entity.ProductVO;
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
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductCommentsMapper productCommentsMapper;

//    @Test
//    public void contextLoads() {
//        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
//        for (CategoryVO c1 : categoryVOS) {
//            System.out.println(c1.toString());
//            for (CategoryVO c2 : categoryVOS) {
//                System.out.println("\t" + c2.toString());
//                for (CategoryVO c3 : categoryVOS) {
//                    System.out.println("\t\t" + c3.toString());
//                }
//            }
//        }
//    }

    @Test
    public void categories(){
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories2(0);
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

    @Test
    public void testRecommend(){
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        for (ProductVO p : productVOS){
            System.out.println(p);
        }
    }

    @Test
    public void testSelectFirstLevelCategory(){
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstCategories();
        for (CategoryVO c:categoryVOS){
            System.out.println(c);
        }
    }

//    @Test
//    public void testComments(){
//        List<ProductCommentsVO> productCommentsVOS = productCommentsMapper.selectCommentsByProductId("3");
//        for (ProductCommentsVO p:productCommentsVOS){
//            System.out.println(p);
//        }
//    }

}
