package com.shandaxueyuan.service.impl;

import com.shandaxueyuan.bean.UserBean;
import com.shandaxueyuan.cache.TokenCache;
import com.shandaxueyuan.dao.UserBeanMapper;
import com.shandaxueyuan.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by HouRuidong on 2016/8/3.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserBeanMapper userDao;

    @Override
    public UserBean getUserByUsername(String username) {
        UserBean userBean = new UserBean();
        if (username == null || username.trim().equals("")) {
            return null;
        } else {
            userBean = userDao.getUserByUsername(username);
        }
        return userBean;
    }

    @Override
    public boolean isEditorByToken(String token) {
        boolean isEditor = false;
        UserBean userBean = TokenCache.getUserByToken(token);
        if (userBean.getAuthority() == 1) {
            isEditor = true;
        }
        return isEditor;
    }

    @Override
    public String getUsernameByUserId(int userId) {
        return userDao.getUsernameByPrimaryKey(userId);
    }
}
