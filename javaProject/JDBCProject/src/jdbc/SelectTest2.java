package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest2 {//PreparedStatement

	public static void main(String[] args) {
		 
		try {
			// 1. 드라이버 로드 : Class.forName("클래스의 풀네임");
			// Class.forName("oracle.jdbc.driver.OracleDriver"); 이 부분을 생략하교 String dbUrl~~~부터 시작해도됨
			
			// 2. Connection 객체를 생성 : 연결 정보
			// -> jdbcUrl
			
//			Oracle 연결
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl,"hr","tiger");
			
//			Mysql연결
//			String dbUrl = "jdbc:mysql://localhost:3306/project";
//			Connection conn = DriverManager.getConnection(dbUrl,"himedia","tiger");
			
			
			
//			3. Statement / PreparedStatement => Statement / PreparedStatement가 하는 역할은 sql 실행 요청을하는 메소드
			
			
			//sql
			String sql = "select * from dept where deptno=?"; // ? 2개를 사용해서 각각의 아래쪽에 ? 파라미터 설정 부분에서 받는다./ 
			PreparedStatement pstmt = conn.prepareStatement(sql);//만듬
			//? 파라미터 설정
			pstmt.setInt(1, 10);
			
			
//			4. select의 결과 데이터는 ResultSet객체로 받는다.			
//			select 실행 메소드 : executeQuery();
			ResultSet rs = pstmt.executeQuery(); //ResultSet rs = stmt.executeQuery(sql);는 안에 sql넣지만 prepared는 넣지않음 ->여기서 conn.prepareStatement(sql)이미 sql넣어서 안넣음 = 이미 prepared가 만들어짐
						
//			5. ResultSet 객체에서 데이터 추출
		
//			while (rs.next()) {
//				System.out.println(rs.getInt(1)+"\t" +rs.getString(2)+"\t"+rs.getString(3));
//			}
			if (rs.next()) { //위에 while이랑 달리 if를 씀 
				System.out.println(rs.getInt(1)+"\t" +rs.getString(2)+"\t"+rs.getString(3));
			}
			
		
			
						rs.close();
						pstmt.close();
						conn.close();
	
		
		}

		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("연결 실패......");
			e.printStackTrace();
		}
		
		
		
		
	}
}
