package firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

	
	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//
//		
//		//사용자요청처리
//		String userid = request.getParameter("userid");
//		System.out.println("사용자 입력 id : " + userid);
//		String password = request.getParameter("password");
//		System.out.println("사용자 입력 pw : " + password);
//		//응답
//		PrintWriter out = response.getWriter();
//		out.println("id : " + userid);
//		out.println("pw : " + password);
//		out.close();
//		
//	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		String userid = request.getParameter("userid");
//		System.out.println("사용자 입력 id : " + userid);
//		String password = request.getParameter("password");
//		System.out.println("사용자 입력 pw : " + password);
//		//응답
//		PrintWriter out = response.getWriter();
//		out.println("id : " + userid);
//		out.println("pw : " + password);
//		out.close();
//		
//	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String userid = request.getParameter("userid");
		System.out.println("사용자 입력 id : " + userid);
		String password = request.getParameter("password");
		System.out.println("사용자 입력 pw : " + password);
		//응답
		PrintWriter out = response.getWriter();
		out.println("id : " + userid);
		out.println("pw : " + password);
		out.close();
		
		
	}

}
