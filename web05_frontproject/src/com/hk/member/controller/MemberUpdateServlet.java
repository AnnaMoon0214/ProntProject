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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 사용자 정보를 화면에 표시하고
		// 수정할수 있도록 기능을 작성
		// /member/list에서 넘어오는데 .. GET방식이며 no에 parameter를 넘긴다.
		// /member/update?no=숫자 (표시타입은 숫자이지만 실제 데이터타입은 String)

		int no = Integer.parseInt(request.getParameter("no"));
		
		Connection conn = null;
		Member member = null;
		
		try { 
			ServletContext sc = this.getServletContext();

			//conn = (Connection) sc.getAttribute("conn");
			
		
			 //ResultSet에 결과가 1 ROW만 있을때는 rs.next(); 로 1개만 꺼낼수 있다.
			
			//MemberDao memberDao = new MemberDao();
			//memberDao.setConnection(conn);
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			member = memberDao.selectOne(no);
						
			response.setContentType("text/html; charset=UTF8");
			request.setAttribute("member",member);
				
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberUpdateGet.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			

		}

	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 사용자가 수정한 정보를 가져와서 DB에 저장
		// 사용자가 보내오는 정보 키워드는 어디서 확인? doGet()
		// name,email, password, cre_date
		
		//request.setCharacterEncoding("UTF-8");

//		System.out.println("no = " + request.getParameter("no"));
//		System.out.println("name = " + request.getParameter("name"));
//		System.out.println("email = " + request.getParameter("email"));
//		System.out.println("password = " + request.getParameter("password"));
//		System.out.println("cre_date = " + request.getParameter("cre_date"));
		
		Connection conn = null;
		

		try { 
			ServletContext sc = this.getServletContext();

			//conn = (Connection) sc.getAttribute("conn");

			
			Member member = new Member();
			member.setNo(Integer.parseInt(request.getParameter("no")));
			member.setName(request.getParameter("name"));
			member.setEmail(request.getParameter("email"));
			member.setPassword(request.getParameter("password"));
			
			//MemberDao memberDao = new MemberDao();
			//memberDao.setConnection(conn);
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			memberDao.update(member);
			
			
			response.setContentType("text/html; charset=UTF-8");

			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberUpdatePost.jsp");
			rd.include(request, response);
			
		} catch(Exception e) {
			throw new ServletException(e);
			
		}finally {

		}

	}
}
