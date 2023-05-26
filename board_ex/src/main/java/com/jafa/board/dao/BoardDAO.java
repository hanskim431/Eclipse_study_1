package com.jafa.board.dao;

import java.util.List;

import com.jafa.board.domain.BoardVO;

public interface BoardDAO {
//list, crud 리스트, 생성 읽기 수정 삭제

	// 게시물 목록 LIST
	List<BoardVO> boardList();
	
	// 게시물 생성 C
	void insertBoard(BoardVO vo);
	
	// 게시물 읽기 R
	BoardVO get(Long bno);
	
	// 게시물 수정 U
	void updateBoard(BoardVO vo);
	
	// 게시물 삭제 D
	void delBoard(Long bno);
	
}
