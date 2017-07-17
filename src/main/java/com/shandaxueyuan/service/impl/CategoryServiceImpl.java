package com.shandaxueyuan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shandaxueyuan.dao.CategoryBeanMapper;
import com.shandaxueyuan.service.CategoryService;

/**
 * Created by Administrator on 2016-08-13.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	CategoryBeanMapper categoryBeanMapper;

	@Override
	public int getCateIdByCate(String title) {
		if (title != "") {
			int cateId = categoryBeanMapper.getCateIdByTitle(title);
			return cateId;
		} else {
			int cateId = 0;
			return cateId;
		}
	}
}
