package com.oh.app.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oh.app.board.BoardVO;
import com.oh.app.common.JDBC;

@Repository("boardDAO")
public class BoardDAO1{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board (id,title,writer,content) values((select nvl(max(id),0)+1 from board),?,?,?)";
		System.out.println("BoardDAO1 - insertBoard() 실행중...");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void updateBoard(BoardVO vo) {
		String sql = "update board set title=?, content=? where id=?";
		System.out.println("BoardDAO1 - updateBoard() 실행중...");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void deleteBoard(BoardVO vo) {
		String sql = "delete from board where id=?";
		System.out.println("BoardDAO1 - deleteBoard() 실행중...");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		String sql = "select * from board where id=?";
		BoardVO data = null;
		System.out.println("BoardDAO1 - getBoard() 실행중...");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		String sql = "select * from board order by id desc";
		List<BoardVO> datas = new ArrayList();
		System.out.println("BoardDAO1 - getBoardList() 수행중...");
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
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
