package com.oh.app.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.oh.app.board.BoardVO;

public class BoardDAO2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board (id,title,writer,content) values((select nvl(max(id),0)+1 from board),?,?,?)";
		System.out.println("BoardDAO2 - insertBoard() 실행중...");
		
		jdbcTemplate.update(sql, vo.getTitle(), vo.getWriter(),vo.getContent());
	}
	
	public void updaetBoard(BoardVO vo) {
		String sql = "update board set title=?, content=? where id=?";
		System.out.println("BoardDAO2 - updateBoard() 실행중...");
		
		jdbcTemplate.update(sql, vo.getTitle(), vo.getContent(), vo.getId());
	}
	
	public void deleteBoard(BoardVO vo) {
		String sql = "delete from board "
	}
	
}
