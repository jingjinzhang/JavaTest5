package com.hand.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.api.dto.Page;
import com.hand.api.service.UserService;
import com.hand.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int confirm(Map<String, Object> map) {

		Map<String, Object> user = userMapper.selectByLoginInfo(map);
		if (user != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public Map<String, Object> update(int id, Map<String, Object> map) {
		map.put("id",id);
		int res = userMapper.updateUser(map);
		if(res > 0){
			return userMapper.selectOneById(id);
		}
		return new HashMap<>();
	}

	@Override
	public PageInfo<Map<String, Object>> listFilm(Page page) {

		PageHelper.startPage(page.getPage(), page.getPageSize());
		PageHelper.orderBy("film_id "+page.getSort());
		List<Map<String, Object>> mapList = userMapper.selectAllFilm();
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(mapList);
		return pageInfo;
	}

	@Override
	public Map<String, Object> create(Map<String, Object> map) {

		Integer res = userMapper.isExistAddress(map.get("address").toString());
		System.out.println(res);
		if (res != null) {
			map.put("addressId",res);
			int res2 = userMapper.insertUser(map);
			if(res2 > 0 ){
				Map<String,Object> loginMap = new HashMap<>();
				loginMap.put("name",map.get("firstName"));
				loginMap.put("password",map.get("lastName"));
				return userMapper.selectByLoginInfo(loginMap);
			}
		}
		return null;
	}

	@Override
	public int delete(int id) {
		return userMapper.deleteUser(id);
	}
}
