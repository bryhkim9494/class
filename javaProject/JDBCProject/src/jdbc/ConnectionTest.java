package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {

		try {
			// 1. 드라이버 로드 : Class.forName("클래스의 풀네임");
			// Class.forName("oracle.jdbc.driver.OracleDriver"); 이 부분을 생략하고 바로  String dbUrl~~~부터 시작해도됨, 1.7버전까지는 이과정을 했었어야함.

			// 2. Connection 객체를 생성 : 연결 정보
			// -> jdbcUrl

//			Oracle 연결
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl,"hr","tiger");

//			Mysql연결
//			String dbUrl = "jdbc:mysql://localhost:3306/project";    // project 는 mysql에 데이터베이스 이름이다.
//			Connection conn = DriverManager.getConnection(dbUrl, "himedia", "tiger");

//			3. Statement / PreparedStatement => 하는 역할은 sql 실행 요청을하는 메소드
//			4. select의 결과 데이터는 ResultSet객체로 받는다.
//			5. ResultSet 객체에서 데이터 추출

			if (conn != null) {
				System.out.println("데이터베이스 연결!!!");
				conn.close(); // 자원의 반납
			}

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
