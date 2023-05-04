package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.domain.MemberDTO;
import member.service.MemberLoginService;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	MemberLoginService loginService;
	
	public LoginController() {
		
		this.loginService = new MemberLoginService();
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("LoginController...doGet()...");
		
		request.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("LoginController...doPost()...");
		
		// 사용자가 입력한 id/pw 받아서 인증처리
		String mid = request.getParameter("mid");
		String pw = request.getParameter("pw");
		String reid = request.getParameter("reid");
//		System.out.println("reid : " + reid);
		
		
		
		// 현재 세션 정보 획득
		HttpSession session = request.getSession(); 
		
		// 인증처리 : id pw 같은 문자열 일때 인증되었다!
		// 인증처리 : id, pw 값을 service로 전달하고 service는 dao로 전달해서 MemberDTO객체를 반환받고싶음
		MemberDTO member = loginService.login(mid, pw);
		
		
		// 전달받은 MemeberDTO 객체가 null이면 회원이 아니다, null이 아니면 회원이다. => 회원이면 로그인 처리를 해줌
		
		if(member != null) {
			// 회원이다!!!! -> HttpSession 객체에 회원정보를 저장
			// 저장된 회원정보는 회원이 로그인 했다의 판단 기준으로 사용
			session.setAttribute("loginInfo", member);
			
			// reid 값이 on이면 쿠키 저장
			if(reid !=null && reid.equals("on")) {
				Cookie cookie = new Cookie("reid", mid);
				cookie.setMaxAge(60*60*24*180);
				cookie.setPath("/");
				response.addCookie(cookie);
				
			} else {
				
				Cookie cookie = new Cookie("reid","aa");
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			
			
			
			response.sendRedirect("/app/index.jsp");
			//return ;
		} else {
			System.out.println("인증실패");
			response.sendRedirect("/app/login");
		}
	
	
	
	}

}