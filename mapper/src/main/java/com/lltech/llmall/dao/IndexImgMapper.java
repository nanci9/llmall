package com.lltech.llmall.dao;

import com.lltech.llmall.entity.IndexImg;
import com.lltech.llmall.general.GeneralDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexImgMapper extends GeneralDAO<IndexImg> {
    public List<IndexImg> listIndexImgs();
}