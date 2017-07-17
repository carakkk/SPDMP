package com.shandaxueyuan.service;

import com.shandaxueyuan.bean.UserBean;

/**
 * Created by HouRuidong on 2016/8/3.
 */
public interface UserService {
    public UserBean getUserByUsername(String username);

    public boolean isEditorByToken(String token);

    public String getUsernameByUserId(int userId);
}
