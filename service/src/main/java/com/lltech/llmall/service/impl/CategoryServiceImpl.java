package com.lltech.llmall.service.impl;

import com.lltech.llmall.dao.CategoryMapper;
import com.lltech.llmall.entity.CategoryVO;
import com.lltech.llmall.service.CategoryService;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        return new ResultVO(ResStatus.OK,"success",categoryVOS);
    }
}
