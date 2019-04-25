package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.dao.UserMapper;
import com.mybatis.domain.User;

public class Demo {
	
	public static void main(String[] args) {
		//1)加载配置文件
		String res = "mybatis-config.xml";
		try {
			//2)获取res对应的配置文件的输入流对象
			InputStream is = Resources.getResourceAsStream(res);
			//3)获取SqlsessionFactory对象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//4)获取Sqlsession
			SqlSession ss = factory.openSession();//true允许自动提交
			//5)获取接口对象
			UserMapper um = ss.getMapper(UserMapper.class);//类名.class
			//6)执行UserMapper接口中的方法
			User u = new User();
			u.setUid(4);
//			u.setUname("a");
//			System.out.println("u===="+u);
			Map<Integer, User> users = um.getUsersByKey(u);
			//遍历Map集合
			Set<Integer> keys = users.keySet();
			for(Integer k : keys) {
				System.out.println(k + "=" + users.get(k));
			}
			ss.commit();//提交
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
