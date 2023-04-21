package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DeptDao;
import domain.Dept;
import util.ConnectionProvider;

public class DeptUpdateService {

	DeptDao dao;

	// 싱글톤 시작
	private DeptUpdateService() {
		super();
		// TODO Auto-generated constructor stub
		this.dao = DeptDao.getInstance();
	}

	private static DeptUpdateService service = new DeptUpdateService();

	public static DeptUpdateService getInstance() {
		return service;
	}
	// 싱글톤 끝

	public int updateDept(Dept newDept) {
		Connection conn = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection(); // Connection 구해오는 코드
			result = dao.updateDeptByDeptno(conn, newDept);

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
	}

}
