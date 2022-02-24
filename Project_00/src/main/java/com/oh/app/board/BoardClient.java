package com.oh.app.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		BoardService bs = (BoardService)factory.getBean("BoardService");
		BoardVO vo = new BoardVO();
		
		/*vo.setTitle("SmartPhoneCompany");
		vo.setWriter("Apple");
		vo.setContent("Samsung");
		bs.insertBoard(vo); //2번 추가
		
		vo.setTitle("CPU");
		vo.setWriter("AppleM1");
		vo.setContent("intelCore");
		bs.insertBoard(vo); //3번 추가
		
		vo.setTitle("제목변경");
		vo.setContent("내용변경");
		vo.setId(1);
		bs.updateBoard(vo); //1번 변경*/
		
		/*
		vo.setId(1);
		BoardVO data = bs.getBoard(vo);
		System.out.println(data); // 1번 조회
		*/
		
		vo.setId(1);
		bs.deleteBoard(vo); //1번 추가
		
		List<BoardVO> datas = bs.getBoardList(vo);
		for(BoardVO v:datas) {
			System.out.println(v); // 글 목록
		}
	}
}
