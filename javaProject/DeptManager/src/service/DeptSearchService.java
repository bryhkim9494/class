package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DeptDao;
import domain.Dept;
import util.ConnectionProvider;

public class DeptSearchService {

	DeptDao dao;

//	public DeptSearchService(DeptDao dao) {
//		super();
//		this.dao = dao;
//		
//	}

//	public DeptSearchService() {
//		super();
//		this.dao = new DeptDao(); // 위에 생성자랑 같은 의미
//	}
	
	
	// 싱글톤 시작
	private DeptSearchService() {
		super();
		this.dao = DeptDao.getInstance(); // 위에 생성자랑 같은 의미
	}
	private static DeptSearchService service = new DeptSearchService();
	public static DeptSearchService getInstance() {
		return service;
	}
	// 싱글톤 끝

	// 검색 번호를 받고 Dept 정보를 저장하고 있는 객체를 반환
	public Dept searchDept(int deptno) {
		Connection conn = null;
		Dept dept = null;

		try {
			conn = ConnectionProvider.getConnection();
//			dept = dao.selectByDeptno(conn, deptno);
			dept = dao.selectByDeptno(conn, deptno);
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
		return dept;

	}

}
