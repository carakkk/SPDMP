package com.shandaxueyuan.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shandaxueyuan.bean.UserBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HouRuidong on 2016/8/3.
 */
public class TokenCache {
    private static Map<String, UserBean> tokenMap = new HashMap<>();

    public static void put(String token, UserBean user) {
        tokenMap.put(token, user);
    }

    public static UserBean getUserByToken(String token) {
        return tokenMap.get(token);
    }

    public static void printTokenMap() throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(tokenMap));
    }
}
