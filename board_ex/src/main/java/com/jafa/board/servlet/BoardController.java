package com.jafa.board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jafa.board.dao.BoardDAO;
import com.jafa.board.dao.BoardDaoOracle;
import com.jafa.board.domain.BoardVO;

@WebServlet("/board/*")
public class BoardController extends HttpServlet{
	
	private String pathInfo;
	private String method;
	private BoardDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao = new BoardDaoOracle();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String nextPage = null;
		String contextPath = request.getContextPath();
		pathInfo = request.getPathInfo();
		pathInfo = pathInfo != null ? pathInfo : "/";
		method = request.getMethod();

		// 리스트 
		if(pathInfo.equals("/list")) {
			List<BoardVO> boardList = dao.boardList();
			request.setAttribute("list", boardList); // list.jsp ${list}
			
			nextPage = "list";
		}
		
		// C-FORM
		else if (pathInfo.equals("/register") && method.equals("GET")) {
			
			nextPage = "register";
		} 
		
		// C
		else if (pathInfo.equals("/register") && method.equals("POST")) {
			BoardVO vo = BoardVO.builder()
					.title(request.getParameter("title"))
					.writer(request.getParameter("writer"))
					.content(request.getParameter("content"))
					.build();
			
			dao.insertBoard(vo);
			
			response.sendRedirect("list");
			return;
		} 
		
		// R
		else if (pathInfo.equals("/get")) {
			
			try {
				Long bno = Long.parseLong(request.getParameter("bno"));
				request.setAttribute("vo", dao.get(bno));
				nextPage = "get";
				
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("/WEB-INF/views/error/bad_request.jsp");
				return;
			}
			
		} 
		
		// U-FORM
		else if (pathInfo.equals("/update") && method.equals("GET")) {
			try {
				Long bno = Long.parseLong(request.getParameter("bno"));
				request.setAttribute("vo", dao.get(bno));
				nextPage = "modify";
				
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("/WEB-INF/views/error/bad_request.jsp");
				return;
			}
			
		} 
		
		// U
		else if (pathInfo.equals("/update") && method.equals("POST")) {
			try {
				BoardVO vo = BoardVO.builder()
						.bno(Long.parseLong(request.getParameter("bno")))
						.title(request.getParameter("title"))
						.content(request.getParameter("content"))
						.build();
				
				dao.updateBoard(vo);
				
				response.sendRedirect("list");
				return;
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
				
		} 
		
		// D
		else if (pathInfo.equals("/del")) {
			Long bno = Long.parseLong(request.getParameter("bno"));
			dao.delBoard(bno);
			
			response.sendRedirect("list");
			return;
		} 
		
		//404
		else {
			request.getRequestDispatcher("/WEB-INF/views/error/_404.jsp")
			.forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/views/board/" + nextPage + ".jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
}