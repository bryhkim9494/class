package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. 드라이버 로드 : Class.forName("클래스의 풀네임");
			// Class.forName("oracle.jdbc.driver.OracleDriver"); 이 부분을 생략하교 String
			// dbUrl~~~부터 시작해도됨

			// 2. Connection 객체를 생성 : 연결 정보
			// -> jdbcUrl

//			Oracle 연결
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dbUrl, "hr", "tiger");

			// 트랜젝션 설정
			conn.setAutoCommit(false);

//			Mysql연결
//			String dbUrl = "jdbc:mysql://localhost:3306/project";
//			Connection conn = DriverManager.getConnection(dbUrl,"himedia","tiger");

//			3. Statement / PreparedStatement => 하는 역할은 sql 실행 요청을하는 메소드

			// insert sql
			String sql = "delete from dept where deptno=?"; // 전체를 다 못바꿈? update? , deptno 는 pk여서 0또는 1-> 컬럼의 특징?
															// dept테이블에서 deptno는 primary key니까 0개의행 1개의행
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 50);

			// dml은 다 똑같이 진행됨 (insert ,update,delete)
			int result = pstmt.executeUpdate(); 

			if (result == 1) { // 조건이 맞지않으면 0이나옴
				System.out.println("데이터가 삭제되었습니다.");
			}
			// 완료 commit
			conn.commit();

		}
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.out.println("연결 실패......");

			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
