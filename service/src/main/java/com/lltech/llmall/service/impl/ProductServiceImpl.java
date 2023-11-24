package com.lltech.llmall.service.impl;

import com.lltech.llmall.dao.ProductImgMapper;
import com.lltech.llmall.dao.ProductMapper;
import com.lltech.llmall.dao.ProductParamsMapper;
import com.lltech.llmall.dao.ProductSkuMapper;
import com.lltech.llmall.entity.*;
import com.lltech.llmall.service.ProductService;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImgMapper productImgMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private ProductParamsMapper productParamsMapper;
    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        return new ResultVO(ResStatus.OK,"success",productVOS);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResultVO getProductBaseInfo(String productId) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        criteria.andEqualTo("productStatus",1);
        List<Product> products = productMapper.selectByExample(example);

        if (products.size() > 0){
            Example example1 = new Example(ProductImg.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("itemId",productId);
            List<ProductImg> productImgs = productImgMapper.selectByExample(example1);

            Example example2 = new Example(ProductSku.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("productId",productId);
            criteria2.andEqualTo("status",1);
            List<ProductSku> productSkus = productSkuMapper.selectByExample(example2);

            HashMap<String,Object> basicInfo = new HashMap<>();
            basicInfo.put("product",products.get(0));
            basicInfo.put("productImgs",productImgs);
            basicInfo.put("productSkus",productSkus);

            return new ResultVO(ResStatus.OK,"success",basicInfo);
        }else {
            return new ResultVO(ResStatus.NO,"商品不存在或已经下架",null);
        }

    }

    @Override
    public ResultVO getProductParamsById(String productId) {
        Example example = new Example(ProductParams.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        List<ProductParams> productParams = productParamsMapper.selectByExample(example);
        if (productParams.size()>0){
            return new ResultVO(ResStatus.OK,"success",productParams);
        }else {
            return new ResultVO(ResStatus.NO,"此商品可能为三无产品",null);
        }
    }

}
