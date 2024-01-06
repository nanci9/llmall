package com.lltech.llmall.service.impl;

import com.lltech.llmall.dao.ProductCommentsMapper;
import com.lltech.llmall.entity.ProductComments;
import com.lltech.llmall.entity.ProductCommentsVO;
import com.lltech.llmall.service.ProductCommentsService;
import com.lltech.llmall.utils.PageHelper;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductCommentsServiceImpl implements ProductCommentsService {

    @Autowired
    private ProductCommentsMapper productCommentsMapper;
    @Override
    public ResultVO getProductCommentsById(String productId,int pageNum,int limit) {
        //List<ProductCommentsVO> productCommentsVOS = productCommentsMapper.selectCommentsByProductId(productId);
        //return new ResultVO(ResStatus.OK,"success",productCommentsVOS);

        //1.根据商品id查询总记录数
        Example example = new Example(ProductComments.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        int count = productCommentsMapper.selectCountByExample(example);

        //2.计算总页数
        int pageCount = count%limit == 0 ? count/limit : count/limit + 1;

        //3.c查询当前页的数据
        int start = (pageNum - 1)*limit;
        List<ProductCommentsVO> productCommentsVOS = productCommentsMapper.selectCommentsByProductId(productId, start, limit);

        return new ResultVO(ResStatus.OK,"success",new PageHelper<ProductCommentsVO>(count,pageCount,productCommentsVOS));
    }
}
