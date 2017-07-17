package com.shandaxueyuan.dao;

import com.shandaxueyuan.bean.CategoryBean;

import java.util.List;

public interface CategoryBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryBean record);

    int insertSelective(CategoryBean record);

    CategoryBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryBean record);

    int updateByPrimaryKey(CategoryBean record);

    List getCategoryChoices(int classifiction);

    int getCateIdByTitle(String title);
}