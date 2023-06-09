package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {// select할때는 이대로만 하면됨 (statement)

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

//			3. Statement / PreparedStatement => Statement / PreparedStatement가 하는 역할은 sql 실행 요청을하는 메소드

			Statement stmt = conn.createStatement();
			// sql
			String sql = "select deptno,dname,loc from dept"; // 여기 부분(sql구문)만 바뀌고 나머지는 다 똑같이 재활용함.

//			4. select의 결과 데이터는 ResultSet객체로 받는다.
//			select 실행 메소드 : executeQuery(String sql);

			ResultSet rs = stmt.executeQuery(sql); //select일때 executeQuery메소드사용하고 나머지 insert,update,delete일때는 executeUpdate메소드 사용
//			5. ResultSet 객체에서 데이터 추출

			while (rs.next()) {
//				int deptno = rs.getInt("deptno");
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");

				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);

				System.out.println(deptno + "\t" + dname + "\t" + loc);

			}

			rs.close();
			stmt.close();
			conn.close(); // 역순으로 닫아줌
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("연결 실패......");
			e.printStackTrace();
		}

	}
}
