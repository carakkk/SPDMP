package com.shandaxueyuan.service;

import com.shandaxueyuan.bean.LogBean;

/**
 * Created by Administrator on 2016-08-12.
 */
public interface LogService {
    public LogBean[] getAlllogsByProdId(Integer prodId);
}
