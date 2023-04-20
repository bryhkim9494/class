package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {

	public static void main(String[] args) {

		try {
			// 1. 드라이버 로드 : Class.forName("클래스의 풀네임");
			// Class.forName("oracle.jdbc.driver.OracleDriver"); 이 부분을 생략하교 String
			// dbUrl~~~부터 시작해도됨

			// 2. Connection 객체를 생성 : 연결 정보
			// -> jdbcUrl

//			Oracle 연결
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl, "hr", "tiger");

//			Mysql연결
//			String dbUrl = "jdbc:mysql://localhost:3306/project";
//			Connection conn = DriverManager.getConnection(dbUrl,"himedia","tiger");

//			3. Statement / PreparedStatement => 하는 역할은 sql 실행 요청을하는 메소드

			// insert sql
			String sql = "update dept set dname=?,loc=? where deptno=?"; // 전체를 다 못바꿈? update?
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "디자인팀");
			pstmt.setString(2, "제주");
			pstmt.setInt(3, 50);
			// dml은 다 똑같이 진행됨 (insert ,update,delete)
			int result = pstmt.executeUpdate();

			if (result > 0) { // 조건이 맞지않으면 0이나옴
				System.out.println("데이터가 수정되었습니다.");
			}

			pstmt.close();
			conn.close();

		}
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.out.println("연결 실패......");
			e.printStackTrace();
		}

		// 3.
	}
}
