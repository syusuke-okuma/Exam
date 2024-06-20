<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%!

//add関数の定義 足し算の結果を返す関数
//int型を返す関数 引数が2つ必要
int add(int a,int b) {
	return a+b;//引数を足した答えを返す
}
%>

<%-- 関数を呼び出しは「式」を使って呼び出すと楽に表示できる --%>
<p>1+2=<%=add(1,2) %></p>
<p>3+4=<%=add(3,4) %></p>

<%@include file="../footer.html" %>