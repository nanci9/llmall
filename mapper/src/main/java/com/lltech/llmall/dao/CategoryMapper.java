package com.lltech.llmall.dao;

import com.lltech.llmall.entity.Category;
import com.lltech.llmall.entity.CategoryVO;
import com.lltech.llmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends GeneralDAO<Category> {
    //链接查询 查询所有类别
    List<CategoryVO> selectAllCategories();

    //子查询 根据parentid查询子分类
    List<CategoryVO> selectAllCategories2(int parentId);

    //查询所有一级分类
    List<CategoryVO> selectFirstCategories();
}