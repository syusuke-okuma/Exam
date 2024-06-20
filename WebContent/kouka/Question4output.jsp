<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.html"%>

<p><font size="6">Question4</font></p>
<% request.setCharacterEncoding("UTF-8");%>
<p>入力されたお名前は・・・,
   <%=request.getParameter("user")%>
   ですね！</p>

<%@include file="../footer.html"%>