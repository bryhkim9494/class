package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.List;

import dao.DeptDao;
import domain.Dept;
import util.ConnectionProvider;

public class DeptListService {

	DeptDao dao;
	
	// 싱글톤 시작
	private DeptListService() {
		super();
		this.dao = DeptDao.getInstance();
	}
	private static DeptListService service = new DeptListService();
	public static DeptListService getInstance() {
		return service;
	}
	// 싱글톤 끝
	
	public List<Dept> getDeptList() {

		Connection conn = null;
		List<Dept> list = null;

		try {

			// Connection 객체 구하기
//			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
//			conn = DriverManager.getConnection(dbUrl,"hr","tiger");
			conn = ConnectionProvider.getConnection();
			// 트랜젝션 시작
			conn.setAutoCommit(false);

			/*
			 * ex) insert update select update insert
			 * 
			 * commit
			 */
			list = dao.selectByAll(conn);

			// commit (완료가 다 되면)
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// 예외 발생했으면 rollback
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			}

			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		DeptListService listService = new DeptListService();

		List<Dept> list = listService.getDeptList();

		for (Dept d : list) {
			System.out.println(d);
		}

	}

}
