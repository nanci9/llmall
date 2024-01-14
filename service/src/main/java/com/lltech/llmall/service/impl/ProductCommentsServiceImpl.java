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

import java.util.HashMap;
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

        //3.查询当前页的数据
        int start = (pageNum - 1)*limit;
        List<ProductCommentsVO> productCommentsVOS = productCommentsMapper.selectCommentsByProductId(productId, start, limit);

        return new ResultVO(ResStatus.OK,"success",new PageHelper<ProductCommentsVO>(count,pageCount,productCommentsVOS));
    }

    @Override
    public ResultVO getCommentsCountById(String productId) {
        //1.查询当前商品评论总数
        Example example = new Example(ProductComments.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(productId);
        int total = productCommentsMapper.selectCountByExample(example);

        //2.查询当前商品好评数
        criteria.andEqualTo("commType",1);
        int goodTotal = productCommentsMapper.selectCountByExample(example);

        //3.查询当前商品中评数
        Example example1 = new Example(ProductComments.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo(productId);
        criteria1.andEqualTo("commType",0);
        int midTotal = productCommentsMapper.selectCountByExample(example1);

        //4.查询当前商品差评数
        Example example2 = new Example(ProductComments.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo(productId);
        criteria2.andEqualTo("commType",-1);
        int badTotal = productCommentsMapper.selectCountByExample(example2);

        //5.计算当前商品好评率
        double percent = Double.parseDouble(goodTotal+"") / Double.parseDouble(total+"") *100;
        String percentValue = (percent+"").substring(0,(percent+"").lastIndexOf(".")+3);


        HashMap<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("goodTotal",goodTotal);
        map.put("midTotal",midTotal);
        map.put("badTotal",badTotal);
        map.put("percent",percentValue);


        return new ResultVO(ResStatus.OK,"success",map);
    }
}
