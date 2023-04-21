package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DeptDao;
import domain.Dept;
import util.ConnectionProvider;

public class DeptInsertService {

	DeptDao dao;

	private DeptInsertService() {
		super();
		// TODO Auto-generated constructor stub
		this.dao = DeptDao.getInstance();
	}
	
	private static DeptInsertService service = new DeptInsertService();
	public static DeptInsertService getInstance () {
		return service;
	}

	// 서로다른 패키지를 사용해서 public을 해줘야함
	public int insertDept(Dept dept) { // controller에서 int여서

//		 RequestDept => dname,loc
//		 service가 하는 역할: 데이터 가공
//						 Transaction 

		Connection conn = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			result = dao.insertDept(conn, dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
//		return dao.insertDept(ConnectionProvider.getConnection(), dept);

	}

}
