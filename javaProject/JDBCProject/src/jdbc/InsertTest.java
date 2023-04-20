package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

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
			String sql = "insert into dept values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, "개발팀");
			pstmt.setInt(1, 50);

			pstmt.setString(3, "서울");
			int result = pstmt.executeUpdate(); //executeUpdate메소드가 하는 역할은 DML실행요청하고 결과반환을함
			if (result > 0) {
				System.out.println("데이터가 입력되었습니다.");
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
			System.out.println("연결 실패......");
			e.printStackTrace();
		}

		// 3.
	}
}
