package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.common.MySqlConnect;

public class UserDao {
    MySqlConnect db=new MySqlConnect();
    Connection conn=db.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    public UserDao() {
        try {

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int login(String userID, String userPassword) {
        String SQL = "SELECT userPassword FROM USER_INFO WHERE userID = ?";
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,userID);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                if(rs.getString(1).equals(userPassword)) {
                    return 1; //로그인 성공
                }
                else
                    return 0; //비밀번호 불일치
            }
            return -1; //아이디가 없음
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -2; //데이터베이스 오류
    }

    public int join(User user) {
        String SQL = "INSERT INTO USER_INFO VALUES (?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, user.getUserID());
            pstmt.setString(2, user.getUserPassword());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getUserGender());
            pstmt.setString(5, user.getUserEmail());

            return pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}