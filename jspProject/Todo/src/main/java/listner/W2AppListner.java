package listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Listner
 *
 */
@WebListener
public class W2AppListner implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed()...");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextInitialized()...");

		try

		{

			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("mysql 드라이버 로드...");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패....");
			e.printStackTrace();
		}
	}

}