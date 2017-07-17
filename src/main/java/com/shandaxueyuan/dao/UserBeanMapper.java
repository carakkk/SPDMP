package com.shandaxueyuan.dao;

import com.shandaxueyuan.bean.UserBean;

public interface UserBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);

    UserBean getUserByUsername(String username);

    String getUsernameByPrimaryKey(Integer id);

}