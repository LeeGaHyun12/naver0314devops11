package data.Dao;

import data.Dto.GuestDto;
import data.Dto.MemoDto;
import db.common.MySqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class MemoDao {
    MySqlConnect db = new MySqlConnect();

    //추가
    public void insertMemo(MemoDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into myMemo (uploadphoto,title,content,writeday) value (?,?,?,now())";

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getUploadPhoto());
            pstmt.setString(2, dto.getTitle());
            pstmt.setString(3, dto.getContent());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    //출력
    public List<MemoDto> getAllMemo() {
        List<MemoDto> list = new Vector<MemoDto>();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from myMemo order by num desc";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemoDto dto = new MemoDto();
                dto.setNum(rs.getInt("num"));
                dto.setUploadPhoto(rs.getString("uploadphoto"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
        return list;
    }

    //상세보기
    public MemoDto getData(int num){
        MemoDto dto=new MemoDto();
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from myMemo where num=?";

        try{
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1,num);
            //실행
            rs=pstmt.executeQuery();
            if(rs.next()){
                dto.setNum(rs.getInt("num"));
                dto.setUploadPhoto(rs.getString("uploadphoto"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }
        return dto;
    }
}
