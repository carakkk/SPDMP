package com.shandaxueyuan.service.impl;

import com.shandaxueyuan.bean.LogBean;
import com.shandaxueyuan.dao.LogBeanMapper;
import com.shandaxueyuan.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016-08-12.
 */
@Service
public class LogServiceImpl implements LogService {
    @Resource
    LogBeanMapper logBeanMapper;
    @Override
    public LogBean[] getAlllogsByProdId(Integer prodId) {
        return logBeanMapper.selectAllByProdId(prodId);
    }
}
