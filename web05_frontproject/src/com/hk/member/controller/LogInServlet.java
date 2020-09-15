package com.hk.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hk.member.dao.MemberDao;
import com.hk.member.dto.Member;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/auth/login")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInForm.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Member member = new Member();
		
		try {
			ServletContext sc = this.getServletContext();
//			conn = (Connection)sc.getAttribute("conn");
			
			
//			System.out.println(request.getParameter("email"));
//			System.out.println(request.getParameter("password"));
			
//			MemberDao memberDao = new MemberDao();
//			memberDao.setConnection(conn);
			
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			
			member = memberDao.exist(request.getParameter("email"),request.getParameter("password"));
			
			if (member!=null) {
				
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				response.sendRedirect("../member/list");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInFail.jsp");
				rd.forward(request, response);
			}
			
			
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			
		}
		
	}

}
