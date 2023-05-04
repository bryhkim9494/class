package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.domain.MemberDTO;
import todo.util.ConnectionProvider;

public class MemberDAO {

	// 로그인 처리를 위한 select
	// uid, pw를 비교해서 처리 => MemberDTO
	public MemberDTO selectByUidPw(Connection conn, String uid, String pw) {

		// 반환할 결과 데이터에대한 변수 선언
		MemberDTO memberDTO = null;

		// SQL 실행을 위한 PreparedStatement 선언 => try{ } finally{ close() }
		PreparedStatement pstmt = null;

		// select의 결과 테이블 저장
		ResultSet rs = null;

		// select에 대한 SQL
		String sql = "select idx, uid, uname, uphoto from member where uid=? and pw=?";

		try {
			pstmt = conn.prepareStatement(sql);
			// set
			pstmt.setString(1, uid); // uid where 조건절에있음
			pstmt.setString(2, pw); // pw는 where 조건절에있음

			// rs 받음
			rs = pstmt.executeQuery(); // 결과 행의 갯수가 0또는 1

			// if
			if (rs.next()) {
				// if => MemberDTO생성
				memberDTO = new MemberDTO(rs.getInt("idx"), rs.getString("uid"), rs.getString("uname"),
						rs.getString("uphoto"));

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
		return memberDTO;

	}

	public static void main(String[] args) throws SQLException {
		MemberDAO dao = new MemberDAO();
		Connection conn = ConnectionProvider.getConnection();

		MemberDTO member = dao.selectByUidPw(conn, "cool", "1234");
		System.out.println(member);

	}

}
