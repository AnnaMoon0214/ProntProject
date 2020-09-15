package com.hk.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.member.dto.Member;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//url을 *.do 로 세팅해놔서 저 *자리에 무슨 url이 오든 거기로 찾아가서 분배하겠다. 이런거지
//		String servletPath=request.getServletPath();
//		System.out.println("servletPath="+servletPath);
		
		response.setContentType("text/html; charset=UTF-8");
		String servletPath=request.getServletPath();
		
		try {
			String pageControllerPath=null;
			
			if("/member/list.do".equals(servletPath)) {
				pageControllerPath="/member/list";
			} else if ("/member/add.do".equals(servletPath)) {
				pageControllerPath="/member/add";//addServlet으로 가는데! 얘가 doPost랑 doGet이있자나그래서 사용자한테 입력을 받는상황을 또 if문으로 조건을 주는거지
				if(request.getParameter("email")!=null) {
					Member member = new Member();
					member.setEmail(request.getParameter("email"));
					member.setName(request.getParameter("name"));
					member.setPassword(request.getParameter("password"));
					request.setAttribute("member", member);
					
				}
				
				System.out.println("내가 Listen하고 있지 않은 URL이 들어오면??어떻게 처리??");
				//에러나면 이제 catch부분으로 가서 /error.jsp로 가게끔 catch문도 해야하는데 우리는 그렇게 하면 다른 에러가 나도 다 그 페이지로 가서 어떤에러가 났는지 
				//찾을수가 없어 그래서 안한다~
			}
			
			RequestDispatcher rd= request.getRequestDispatcher(pageControllerPath);
			rd.include(request, response);
			
			String viewUrl=(String) request.getAttribute("viewUrl");
			if(viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			} else {
				rd=request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
		} catch(Exception e) {
			//에러나면 에러페이지로 넘어감.. 우린 구현 안함
		}
	}

}
