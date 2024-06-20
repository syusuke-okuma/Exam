package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chater14/search"})
public class Search extends HttpServlet {
	public void doPost (
			HttpServletRequest request,
			HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
					"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();
			
			//getParameterメソッド利用してJSPの中で入力された値を入力
			String keyword=request.getParameter("keyword");
			//SQLの設定(作成)
			PreparedStatement st=con.prepareStatement(
					//WHERE句のLIKE式を使って、あいまい検索を行う
					//?（プレースホルダ）を検索文字列を置き換えできるようにする
					"select * from product where name like ?");
			//"%"を使うことでkeywordの前後に文字が付くデータを検索する
			//第一引数に設定した数値番目の"?"を第一
			st.setString(1, "%"+keyword+"%");
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				out.println(rs.getInt("id"));
				out.println(":");
				out.println(rs.getString("name"));
				out.println(":");
				out.println(rs.getInt("price"));
				out.print("<br>");
			}

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}