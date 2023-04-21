package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Dept;

//sql을 실행할수있게 기능들을 만들어 놓은 클래스가 DAO이다.
public class DeptDao {
	
	// DAO: sql을 실행하는 메소드만 가지는 클래스
	// => 여러개의 인스턴스가 생성될 필요가 없다!
	// => 싱글톤처리를 통해 하나의 인스턴스만 사용!
	
	// 싱글톤처리 방법
	// 1. 인스턴스 생성 금지 : private 생성자
	private DeptDao () {
		
	}
	// 2. 클래스 내부에서 인스턴스 생성 : 인스턴스 생성할때 private static이 붙어야함
	private static DeptDao dao = new DeptDao();
	
	// 3. 다른클래스에서 인스턴스를 얻을 수 있도록 메소드가 필요함 : 메소드도 public static이어야함
	public static DeptDao getInstance() {
		return dao;
	}
	

	// 1.dept테이블에 list를 구해주는 메소드 = dept list : List<Dept>
	public List<Dept> selectByAll(Connection conn) { // conn : 참조변수

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
			rs = pstmt.executeQuery(); // select 일때 executeQuery

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

	// 2. 부서번호로 검색하는 기능을하는 메소드 (Connection conn ,int num) -> Connection conn을 매개변수로
	// 받아야함
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
			if (rs.next()) { // 여기서는 행이 한개 나올꺼같아서 while문을 쓰지않음
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

	// 3. 부서정보를 입력해주는 기능을하는 메소드 : deptno,dname,loc를 받아야함 +conn도 받아야함
	public int insertDept(Connection conn, Dept dept) { // 파라미터 3개(deptno,dname,loc)를 더 쓰는것보다 dept객체로 받는게 더 효율적임
		PreparedStatement pstmt = null; // sql실행하려면 PreparedStatement이 필요함
		int result = 0;
		// Insert하기위한 sql
		String sql = "insert into dept values (?,?,?)"; // sql작성전에 디벨로퍼로 들어가서 sql실행해서 확인하는게 좋음
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno()); // dept라는 객체를 받아서 dept.getDeptno()로 접근을 해야함
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc()); // 여기까지 sql완성

			result = pstmt.executeUpdate(); // sql이 이미 만들어져서 괄호안에 sql안넣어도됨 ,pstmt = conn.prepareStatement(sql);여기서 만들어짐

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	// 4. 부서 정보 수정 메소드 : updateDeptByDeptno 파라미터안에 deptno, dname,loc but 비효율적이여서
	// 인스턴스로받음
	public int updateDeptByDeptno(Connection conn, Dept dept) {

		PreparedStatement pstmt = null;
		int result = 0;
		// update sql
		String sql = "update dept set dname = ?,loc = ? where deptno = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	// 5. 부서 정보 삭제 메소드 : deptno => 삭제할 부서 번호
	public int deleteDeptByDeptno(Connection conn, int deptno) {

		PreparedStatement pstmt = null;
		int result = 0;
		// delete 를 하기 위한 sql이 필요함
		String sql = "delete from dept where deptno = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;

	}

	public static void main(String[] args) throws SQLException { // 테스트하려고 만든 main메소드
		DeptDao dao = new DeptDao();

		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(dbUrl, "hr", "tiger");

		List<Dept> list = dao.selectByAll(conn);

		for (Dept dept : list) {
			System.out.println(dept);
		}

		Dept dept = dao.selectByDeptno(conn, 50);
		System.out.println("결과 : " + dept);

//		int insertResult = dao.insertDept(conn, new Dept(50,"TEST","SEOUL")); //바로 new 객체생성
//		int insertResult2 = dao.insertDept(conn,dept);
//		System.out.println("저장 결과 : " + insertResult);
		Dept d = new Dept(50, "TTT", "QQQ"); // 수정하고자 하는 부서 정보를 가지고있는 Dept = 50번 부서를 TTT QQQ로 바꿈
		int updateResult = dao.updateDeptByDeptno(conn, d);
		System.out.println(updateResult);

	}

}
