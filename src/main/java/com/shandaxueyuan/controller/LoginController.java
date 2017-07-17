package com.shandaxueyuan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shandaxueyuan.bean.UserBean;
import com.shandaxueyuan.cache.TokenCache;
import com.shandaxueyuan.constant.ErrorCodeConstant;
import com.shandaxueyuan.constant.SmartResult;
import com.shandaxueyuan.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonObject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by HouRuidong on 2016/8/3.
 */
@RestController
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    SmartResult login(@RequestBody UserBean user2Login, HttpServletResponse response) throws JsonProcessingException {

        SmartResult smartResult = new SmartResult();

        if (!user2Login.getUsername().equals("") && !user2Login.getPassword().equals("")) {
            UserBean userInDb = userService.getUserByUsername(user2Login.getUsername());
            if (userInDb != null) {
                if (userInDb.getPassword().trim().equals(user2Login.getPassword().trim())) {
                    String token = UUID.randomUUID().toString();
                    TokenCache.put(token,userInDb);
                    response.addCookie(new Cookie("token", token));
                    smartResult.setCode(ErrorCodeConstant.CODE_SUCCESS);
                    userInDb.setPassword(null);
                    smartResult.setData(userInDb);
                } else {
                    smartResult.setCode(ErrorCodeConstant.ERRORCODE_LOGIN_INVALIDPASSWORD);
                    smartResult.setMsg(ErrorCodeConstant.ERRORMSG_LOGIN_INVALIDPASSWORD);
                }
            } else {
                smartResult.setCode(ErrorCodeConstant.ERRORCODE_LOGIN_IDCARDNOTFOUND);
                smartResult.setMsg(ErrorCodeConstant.ERRORMSG_LOGIN_IDCARDNOTFOUND);
            }
        } else {
            smartResult.setCode(ErrorCodeConstant.ERRORCODE_REGIST_INVALIDPARAM);
            smartResult.setMsg(ErrorCodeConstant.ERRORMSG_REGIST_INVALIDPARAM);
        }
        return smartResult;
    }

}
