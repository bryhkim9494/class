package firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DateServlet
 */
//@WebServlet({ "/now", "/test/now" }) // localhost:8080/now요청이들어오면 DateServlet을 실행 ,/now 부분이 url mapping을 한거임
public class DateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		Date now = new Date();
		// 응답처리 : html
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>현재 시간</title></head>");

		out.println("<body>");
		out.println("<h1>안녕하세요</h1>");
		out.println("<h3>" + now.toString() + "</h3>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
