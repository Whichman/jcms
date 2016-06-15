package com.joshuait.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.joshuait.entity.Users;

public class UsersDao {
	
	public static final String resource = "com/joshuait/dao/mybatis-config.xml";
	public static InputStream inputStream = null;
	public static SqlSessionFactory sqlSessionFactory = null;

	public static void init() {
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		Users user = new Users();
		/*System.out.println(getById(1));*/
		
		/*user.setUserLogin("admin");
		System.out.println(Search(user));*/
		
		/*user.setUserLogin("abc");
		user.setUserPass("123");
		insert(user);*/
		
		/*delete(16);*/
		
		/*user.setUserLogin("abc11");
		user.setUserPass("123wqww");
		user.setId(15);
		update(user);*/
		
		Search(user);
	}
	
	public static Users getById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		Users user = null;
		try {
			user = (Users) session.selectOne("org.mybatis.example.UsersMapper.getByid", id);
		} finally {
			session.close();
		}
		return user;
	}
	
	public static List<Users> Search(Users user) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Users> list = null;
		try {
			list = session.selectList("org.mybatis.example.UsersMapper.search", user);
		} finally {
			session.close();
		}
		return list;
	}
	
	
	

	public static void insert(Users user) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("org.mybatis.example.UsersMapper.insert", user);
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
	}

	public static void update(Users user) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("org.mybatis.example.UsersMapper.update",user);
		} finally {
			session.commit();
			session.close();
		}

	}
	
	public static void delete(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("org.mybatis.example.UsersMapper.delete",id);
		} finally {
			session.commit();
			session.close();
		}

	}
}
