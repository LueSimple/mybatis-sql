package com.mybatis.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.mybatis.domain.User;

public interface UserMapper {
	
	//条件查询，返回值类型：集合
	//List<User>
	
	//Map<k,v>   k==用户编号      v=user对象
	@MapKey("uid")
	Map<Integer,User> getUsersByKey(@Param("user")User u);
}









