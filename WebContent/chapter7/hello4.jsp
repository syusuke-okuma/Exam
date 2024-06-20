<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.html" %>

<%-- メッセージの出力 --%>
<p>Hello!</p>
<p>こんにちは!</p>

<%--Javaプログラムを記述 システム日付を表示 --%>
<%--<%でJavaプログラムの式の結果を表示する」ことができる --%>
<p><%=new java.util.Date() %></p>
<%@include file ="../footer.html" %>