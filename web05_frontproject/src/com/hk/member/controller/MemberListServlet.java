package com.hk.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Controller 역할 : 
		 * 1)URL설정 - /member/list
		 * 2)Model을 호출 (JDBC6단계중... 1,2,6은 직접하고 3,4,5는 Dao를 통해서 하고
		 * 3)View를 호출
		 */
		ServletContext sc = this.getServletContext();
//		Connection connection = (Connection)sc.getAttribute("conn");
//		MemberDao memberDao = new MemberDao();
//		//memberDao에서 사용하는 connection정보는 누가 만들까?
//		//1) 직접 : Class.forName,getConnection
//		//2) 다른프로그램이 : AppInitServlet url이 servlet을 만들어서 servletcontext 보관해 등록후 그걸 꺼내서 쓴다.
//		memberDao.setConnection(connection);
		
		MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
		
		//selectList()를 호출해서 member list를 받아와야함.
		List<Member> members = new ArrayList<Member>();
		members=memberDao.selectList();
		request.setAttribute("members", members);
		
		request.setAttribute("viewUrl", "/member/MemberList.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
