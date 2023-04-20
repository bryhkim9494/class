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

	public DeptSearchService() {
		super();
		this.dao = new DeptDao(); // 위에 생성자랑 같은 의미
	}

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
		}
		return dept;

	}

}
