package com.hand.infra.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {


	Map<String,Object> selectByLoginInfo(Map<String, Object> map);

	List<Map<String,Object>> selectAllFilm();

	Integer isExistAddress(String address);

	int insertUser(Map<String, Object> map);

	int updateUser(Map<String, Object> map);

	int deleteUser(int id);

	Map<String,Object> selectOneById(int id);
}
