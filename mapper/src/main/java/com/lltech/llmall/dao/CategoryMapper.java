package com.lltech.llmall.dao;

import com.lltech.llmall.entity.Category;
import com.lltech.llmall.entity.CategoryVO;
import com.lltech.llmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends GeneralDAO<Category> {
    public List<CategoryVO> selectAllCategories();
}