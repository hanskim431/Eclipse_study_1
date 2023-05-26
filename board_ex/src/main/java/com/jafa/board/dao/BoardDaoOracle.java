package com.jafa.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.jafa.board.domain.BoardVO;

public class BoardDaoOracle implements BoardDAO{

	private DataSource dataSource;
	
	public BoardDaoOracle() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<BoardVO> boardList() {
		System.out.println("Board.boardList() 호출");
		List<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM BOARD_TBL ORDER BY BNO";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query); 
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = BoardVO.builder()
						.bno(rs.getLong("bno"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.writer(rs.getString("writer"))
						.regDate(rs.getDate("regDate"))
						.updateDate(rs.getDate("updateDate"))
						.build();
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			if(rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return list;
	}

	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("Board.insertBoard() 호출");
		BoardVO boardVO = new BoardVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query ="INSERT INTO BOARD_TBL (BNO,TITLE,CONTENT,WRITER) VALUES(bno_SEQ.nextval,?,?,?)";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public BoardVO get(Long bno) {
		System.out.println("Board.get() 호출");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM BOARD_TBL WHERE BNO=?";
		BoardVO vo = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, bno);
			rs= pstmt.executeQuery();
			
//			if(rs.next()) {	
//				vo.setBno(rs.getLong("bno"));
//				vo.setTitle(rs.getString("Title"));
//				vo.setContent(rs.getString("content"));
//				vo.setWriter(rs.getString("writer"));
//				vo.setRegDate(rs.getDate("regDate"));
//				vo.setUpdateDate(rs.getDate("updateDate"));
//			} // 이거 왜 안됨
			
			if(rs.next()) {
				vo = BoardVO.builder()
						.bno(rs.getLong("bno"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.writer(rs.getString("writer"))
						.regDate(rs.getDate("regDate"))
						.updateDate(rs.getDate("updateDate"))
						.build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return vo;
	}

	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("Board.updateBoard() 호출");
		Connection conn;
		PreparedStatement pstmt;
		String query = "UPDATE BOARD_TBL SET TITLE=?,CONTENT=?,UPDATEDATE=SYSDATE WHERE BNO=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setLong(3, vo.getBno());
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delBoard(Long bno) {
		System.out.println("Board.delBoard() 호출");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM BOARD_TBL WHERE BNO=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, bno);
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
