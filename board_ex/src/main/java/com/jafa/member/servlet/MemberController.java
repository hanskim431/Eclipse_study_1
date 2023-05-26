package com.jafa.member.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jafa.member.dao.MemberDAO;
import com.jafa.member.dao.MemberDaoOracle;
import com.jafa.member.domain.MemberVO;

@WebServlet("/member/*")
public class MemberController extends HttpServlet{
	private MemberDAO dao;
	
	private String pathInfo;
	private String method;
	
	@Override
	public void init() throws ServletException {
//		System.out.println("init");
		dao	= new MemberDaoOracle();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doGet");
		request.setCharacterEncoding("UTF-8");
		String nextPage = null;
		pathInfo = request.getPathInfo();
		pathInfo = pathInfo != null ? pathInfo : "/";
		method = request.getMethod();
		
		// list		GET		/list		list.jsp
		if(pathInfo.equals("/list")) {
			List<MemberVO> memberList = dao.memberList();
			request.setAttribute("list", memberList);
			
			nextPage = "list";
//			System.out.println(memberList);
		}
		
		// C FORM	GET		/join		join.jsp
		else if(pathInfo.equals("/join") && method.equals("GET")) {
			nextPage = "join";
		}
		
		// C		POST	/join
		else if(pathInfo.equals("/join") && method.equals("POST")) {
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPwd(request.getParameter("pwd"));
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			dao.join(vo);
			response.sendRedirect("list");
			return;
		}
		
		// R		GET		/detail		detail.jsp
		else if(pathInfo.equals("/detail") && method.equals("GET")) {
			MemberVO vo = dao.detail(Long.parseLong(request.getParameter("mno")));
			request.setAttribute("vo", vo);
			nextPage = "detail";
		}
		
		// U FORM	GET		/modify		modify.jsp
		else if(pathInfo.equals("/modify") && method.equals("GET")) {
			MemberVO vo = dao.detail(Long.parseLong(request.getParameter("mno")));
			request.setAttribute("vo", vo);
			nextPage = "modify";
		}
		
		// U		POST	/modify
		else if(pathInfo.equals("/modify") && method.equals("POST")) {
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPwd(request.getParameter("pwd"));
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			vo.setMno(Long.parseLong(request.getParameter("mno")));
			dao.modify(vo);
			response.sendRedirect("list");
			return;
		}
		
		// D		POST	/remove	
		else if(pathInfo.equals("/remove") && method.equals("POST")) {
			dao.remove(Long.parseLong(request.getParameter("mno")));;
			response.sendRedirect("list");
			return;
		}
		
		// 404
		else nextPage = "404";
		
		request.getRequestDispatcher("/WEB-INF/views/member/"+nextPage+".jsp").forward(request, response);
	}
}
