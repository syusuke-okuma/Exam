package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter6/checkbox"})
public class Checkbox extends HttpServlet {

	public void doPost (
			HttpServletRequest request, HttpServletResponse response
			) throws ServerException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out=response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String[] genre=request.getParameterValues("genre");

		Page.header(out);
		if (genre!=null) {
			for (String item : genre) {
				out.println("「"+item+"」");
			}
			out.println("お買い得情報はお送りしていません。");
		}
		Page.footer(out);
	}
}
