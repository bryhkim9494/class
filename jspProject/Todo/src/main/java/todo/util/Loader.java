package todo.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet {

	@Override
	public void init() throws ServletException{
		System.out.println("Loader...init().....");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Complete Mysql Driver Load");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fail Driver Load...");
			e.printStackTrace();
		}
	}
}
