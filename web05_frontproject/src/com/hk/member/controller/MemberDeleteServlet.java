package com.hk.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

import com.hk.member.dao.MemberDao;
import com.hk.member.dto.Member;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Delete?no=1
		// ?? 삭제 여부를 확인해야하는데???
		// Client한테 삭제 여부 확인 script를 주고 몇번을 지워야 하는 지도 주고..
		// 예를 들어 /member/list에서 1번을 지우라고 했을때 나한테 no=1,
		// Client에게도 다시 1을 보내줘야한다...
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no = " + no);
		
		response.setContentType("text/html; charset=UTF8");

		request.setAttribute("no", no);
		RequestDispatcher rd = request.getRequestDispatcher("/member/MemberDeleteGet.jsp");
		rd.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("doPost no = " + no);
		
		

		Connection conn = null;
		String name ="";
		
		try { 
			ServletContext sc = this.getServletContext();

			//conn = (Connection) sc.getAttribute("conn");
			
			//MemberDao memberDao = new MemberDao();
			//memberDao.setConnection(conn);
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			
			name = memberDao.delete(no);	
			
			response.setContentType("text/html; charset=UTF8");

			if(name!=null) {
				request.setAttribute("name", name);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberDeletePost.jsp");
			rd.include(request, response);
			
			
			
		} catch(Exception e) {
			throw new ServletException(e);
		} finally {
			

		}
	}
}
