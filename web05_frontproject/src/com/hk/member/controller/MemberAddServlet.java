package com.hk.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.member.dao.MemberDao;
import com.hk.member.dto.Member;

/**
 * Servlet implementation class MemberAddServlet
 */
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=UTF-8");
//		RequestDispatcher rd = request.getRequestDispatcher("/member/MemberAddGet.jsp");
//		rd.include(request, response);
		request.setAttribute("viewUrl", "/member/MemberAddGet.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletContext sc = this.getServletContext();
		
		//conn = (Connection)sc.getAttribute("conn");
		
//		Member member = new Member();
//		
//		member.setEmail(request.getParameter("email"));
//		member.setName(request.getParameter("name"));
//		member.setPassword(request.getParameter("password"));
//		
		MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
		request.setAttribute("name", request.getParameter("name"));
		//MemberDao memberDao = new MemberDao();
		//memberDao.setConnection(conn);
		
		Member member=(Member)request.getAttribute("member");
		memberDao.insert(member);
		
		request.setAttribute("viewUrl", "/member/MemberAddPost.jsp");
//		response.setContentType("text/html; charset=UTF-8");
//		RequestDispatcher rd = request.getRequestDispatcher("/member/MemberAddPost.jsp");
//		rd.include(request, response);
	}

}
