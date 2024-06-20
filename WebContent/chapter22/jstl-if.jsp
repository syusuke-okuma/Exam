<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${Math.random()<0.5}">
	あたり！
</c:if>

<c:url var="result" value = "/chapter8/greeting-out.jsp">
	<c:param name="user" value="ぴぐぺん工房"/>
</c:url>

<%@include file="../footer.html"%>