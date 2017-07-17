package com.shandaxueyuan.dao;

import com.shandaxueyuan.bean.LogBean;

public interface LogBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogBean record);

    int insertSelective(LogBean record);

    LogBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogBean record);

    int updateByPrimaryKey(LogBean record);

    LogBean[] selectAllByProdId(int prodId);
}