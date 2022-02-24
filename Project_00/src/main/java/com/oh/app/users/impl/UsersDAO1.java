package com.oh.app.users.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oh.app.common.JDBC;
import com.oh.app.users.UsersVO;

@Repository("usersDAO")
public class UsersDAO1 {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertUsers(UsersVO vo) {
		String sql = "insert into users (id,password,name,role) values(?,?,?,?)";
		System.out.println("UsersDAO1 - insertUsers() 실행중...");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void updateUsers(UsersVO vo) {
		String sql = "update users set password=?, name=? where id=?";
		System.out.println("UsersDAO1 - updateUsers() 실행중...");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void deleteUsers(UsersVO vo) {
		String sql = "delete from users where id=?";
		System.out.println("UsersDAO1 - deleteUsers() 수행중...");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public UsersVO getUsers(UsersVO vo) {
		String sql = "select * from users where id=?";
		UsersVO data = null;
		System.out.println("UsersDAO - getUsers() 수행중..."); 
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new UsersVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public List<UsersVO> getUsersList(UsersVO vo){
		String sql = "select * from users order by id desc";
		List<UsersVO> datas = new ArrayList();
		System.out.println("UsersDAO1 - getUsersList() 수행중...");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				UsersVO data = new UsersVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
}
