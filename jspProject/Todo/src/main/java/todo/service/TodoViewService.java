package todo.service;

import java.sql.Connection;
import java.sql.SQLException;

import todo.dao.TodoDAO;
import todo.domain.TodoDTO;
import todo.util.ConnectionProvider;

public class TodoViewService {

	
	TodoDAO dao;

	public TodoViewService() {
		this.dao = TodoDAO.getInstance();
	}
	private static TodoViewService service = new  TodoViewService();
	public static TodoViewService getInsance() {
		return service;
		
	}
	
	//tno 값을 전달 받아서
	//dao selectByTno메소드에 요청 => TodoDTO => 반환
	
	public TodoDTO getTodo(int tno) {
		Connection conn = null;
		TodoDTO todo = null;
		try {
			conn = ConnectionProvider.getConnection();
			todo= dao.selectByTno(conn, tno);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		
		return todo;
	}
	
}
