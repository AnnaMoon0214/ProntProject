package com.hk.member.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class AppInitServlet
 */

/*
 * web.xml에 servlet을 등록후 load-on-startup에 1을 주고 tomcat이 실행시
 * 자동으로 실행될수 있도록 설정한다.
 * 이것도 서블릿임으로 생명주기가 있다.. init(), destroy(), service()
 * 그중 init()과 destroy()만 사용한다.
 * init()은 DB접속을 
 * destroy()는 DB접속종료를
 */
public class AppInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// JDBC 1,2단계
		// DB접속정보 : Connection String, ID , PW
		// DB접속정보를 만들어서 servletcontext라고 하는 모든 servlet이
		// 접근가능한 공간에 저장을 해둔다. 
		super.init(config);
		Connection conn = null;
		
		ServletContext sc = this.getServletContext();
		
		try {
			// jdbc1단계
			Class.forName(sc.getInitParameter("driver"));
			String url = sc.getInitParameter("url");
			String user = sc.getInitParameter("username");
			String password = sc.getInitParameter("password");
			// jdbc2단계
			conn = DriverManager.getConnection(url, user, password);
			
			// ServletContext 저장소에 저장..
			sc.setAttribute("conn", conn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		// JDBC 6단계
		ServletContext sc = this.getServletContext();
		
		Connection conn = null;
		conn = (Connection) sc.getAttribute("conn");
		
		try {
			if (conn != null && conn.isClosed()==false) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
