package bbs;

import com.mysql.cj.protocol.x.Notice;
import db.common.MySqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BbsDao {
    static MySqlConnect db = new MySqlConnect();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public BbsDao() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int getNext() {
        String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";

        try {
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
            return 1; // 첫 번째 게시물인 경우
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // 데이터베이스 오류
    }

    public void write(String bbsTitle, String userID, String bbsContent) {
        String SQL = "INSERT INTO BBS ( bbstitle, userID, bbscontent, BBSAVAILABLE) VALUES (?, ?, ?, 1)";
        conn = db.getConnection();
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, bbsTitle);
            pstmt.setString(2, userID);
            pstmt.setString(3, bbsContent);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }


    public List<BbsDto> Notice_getList() {
        List<BbsDto> list = new ArrayList<>();
        String SQL = "SELECT BBSID, BBSTITLE, USERID, BBSDATE, BBSCONTENT, BBSAVAILABLE FROM bbs ORDER BY bbsID DESC";

        try {
            conn = db.getConnection();
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BbsDto bbs = new BbsDto();
                bbs.setBbsID(rs.getInt("BBSID"));
                bbs.setBbsTitle(rs.getString("BBSTITLE"));
                bbs.setUserID(rs.getString("USERID"));
                bbs.setBbsDate(rs.getString("BBSDATE"));
                bbs.setBbsContent(rs.getString("BBSCONTENT"));
                bbs.setBbsAvailable(rs.getInt("BBSAVAILABLE"));
                list.add(bbs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return list;
    }


//
//    public boolean nextPage(int pageNumber) {
//        String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1";
//
//        try {
//            pstmt = conn.prepareStatement(SQL);
//            pstmt.setInt(1, getNext() - (pageNumber -1) * 10);
//            rs = pstmt.executeQuery();
//            if (rs.next()) {
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    public BbsDto getBbs(int bbsID) {
        String SQL = "SELECT * FROM BBS WHERE bbsID = ?";
        BbsDto bbs = new BbsDto();

        try {
            conn = db.getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, bbsID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                bbs.setBbsID(rs.getInt(1));
                bbs.setBbsTitle(rs.getString(2));
                bbs.setUserID(rs.getString(3));
                bbs.setBbsDate(rs.getString(4));
                bbs.setBbsContent(rs.getString(5));
                bbs.setBbsAvailable(rs.getInt(6));
                bbs.setCount(rs.getInt(7));
                bbs.setLike_count(rs.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bbs;
    }

    public int update(int bbsID, String bbsTitle, String bbsContent) {
        String SQL = "UPDATE BBS SET bbsTitle = ?, bbsContent = ? WHERE bbsID =?";


        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, bbsTitle);
            pstmt.setString(2, bbsContent);
            pstmt.setInt(3, bbsID);

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // 데이터베이스 오류
    }

    public int incrementLikeCount(int bbsID) {
        String SQL = "UPDATE BBS SET like_count = like_count + 1 WHERE bbsid = ?";

        try {
            conn = new MySqlConnect().getConnection(); // 혹은 원하는 방식으로 Connection 객체 생성
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, bbsID);
            pstmt.executeUpdate();

            // 좋아요 수가 증가시, 조회수도 증가하기 때문에
            String sql = "update BBS set COUNT = COUNT - 1 where bbsid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bbsID);
            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 필요한 경우 여기에서 pstmt와 conn을 닫습니다.
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1; // 데이터베이스 오류
    }

    public int decreaseLikeCount(int bbsID) {
        String SQL = "UPDATE BBS SET like_count = like_count - 1 WHERE bbsid = ?";

        try {
            conn = new MySqlConnect().getConnection(); // 혹은 원하는 방식으로 Connection 객체 생성
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, bbsID);
            pstmt.executeUpdate();

            // 좋아요 수가 감소시, 조회수도 증가하기 때문에
            String sql = "update BBS set COUNT = COUNT - 1 where bbsid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bbsID);
            return pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 필요한 경우 여기에서 pstmt와 conn을 닫습니다.
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1; // 데이터베이스 오류
    }


    public int increasecount(int bbsID) {
        String SQL = "UPDATE BBS SET COUNT = COUNT + 1 WHERE bbsid = ?";

        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, bbsID);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int delete(int c) {
        String SQL = "UPDATE BBS SET bbsAvailable = 0 WHERE bbsID = ?";

        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, c);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // 데이터베이스 오류
    }


}