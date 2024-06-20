package kouka;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/kouka/question4input"})
public class Question4 extends HttpServlet {

	public void doGet (
		HttpServletRequest request,HttpServletResponse response
	)throws ServletException,IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out= response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String user=request.getParameter("user");

		Page.header(out);
		out.print("<p>こんにちは、"+user+"さん！</P>");
		Page.footer(out);
	}
}