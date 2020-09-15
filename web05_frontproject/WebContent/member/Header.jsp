<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.hk.member.dto.Member"%>

<%
	Member member = (Member) session.getAttribute("member");
%>

<div
	style="background-color: #00008b; color: #ffffff; height: 30px; padding: 5px;">
	SPMP(Simple Project Management System)
	<%if (member != null) {%>
	<span style="float: right;"> 
	${member.name } 
	<a style="color: white;" href="<%=request.getContextPath()%>/auth/logout">로그아웃</a>
	</span>
	<% } else {%>
	<span style="float: right;"> <a style="color: white;"
		href="<%=request.getContextPath()%>/auth/login">로그인</a>
	</span>
	<% } %>
</div>
