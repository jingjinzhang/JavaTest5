package com.hand.api.service;

import com.github.pagehelper.PageInfo;
import com.hand.api.dto.Page;

import java.util.Map;

public interface UserService {


	int confirm(Map<String, Object> map);

	Map<String,Object> update(int id, Map<String, Object> map);

	PageInfo<Map<String, Object>> listFilm(Page page);

	Map<String,Object> create(Map<String, Object> map);

	int delete(int id);
}
