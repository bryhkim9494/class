package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Dept;

public class DeptDao {

	// 1.dept테이블에 list를 구해주는 메소드 = dept list : List<Dept>
	public List<Dept> selectByAll(Connection conn) {

		// Connection
		// 1.메소드 내부에서 Connection을 구하는 방법 (X-비추천)

		/*
		 * 2.Dao 클래스 내부의 인스턴스 변수로 Connection을 구하는 방법 (X-비추천) -Dao클래스는 싱글톤처리 불가,
		 * Connection 구하기 위해서 인스턴스 계속 생성
		 */

		// 3.매개변수로 Connection을 구하는 방법(O)
		// -방법: Service클래스의 메소드에서 Connection을 생성해서 전달

		// 메소든 내부에서 Connection을 구하면 close()를 해줘야함
		// close()

		// <순서>
		// 1.Connection
		// 2.PreparedStatement
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 반환하고자 하는 결과 데이터
		// Collection 클래스중 List => List의 특징은 입력순서를 가진다, index도 가짐,반복문을 통해서 결과 출력
		List<Dept> result = new ArrayList<Dept>();

		// SQL생성
		String sql = "select * from dept";
		try {
			pstmt = conn.prepareStatement(sql);
			// 3.executeQuery
			// 4.ResultSet
			rs = pstmt.executeQuery();

			// 5.while문
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				Dept dept = new Dept(deptno, dname, loc); // 여기 부분에서는 객체 생성
				// List<Dept>에 Dept 객체를 추가해주면됨
				result.add(dept);

//				System.out.println(deptno + dname + loc);

			}

//			result : 4개의 객체를 가지고 있다.

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {
			try {

				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();

			}

		}

		return result;

	}

	// 2. 부서번호로 검색하는 기능을하는 메소드 (Connection conn ,int num) -> Connection conn을 매개변수로 받아야함
	public Dept selectByDeptno(Connection conn, int deptno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept result = null;
		// sql
		String sql = "select * from dept where deptno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

	// 3. 부서정보를 입력해주는 기능을하는 메소드

	// 4. 부서 정보 수정 메소드

	// 5. 부서 정보 삭제 메소드

	public static void main(String[] args) throws SQLException {
		DeptDao dao = new DeptDao();

		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(dbUrl, "hr", "tiger");

	
		List<Dept> list = dao.selectByAll(conn);

		for (Dept dept : list) {
			System.out.println(dept);
		}

		
		Dept dept = dao.selectByDeptno(conn, 10);
		System.out.println("결과 : " + dept);

	}

}
