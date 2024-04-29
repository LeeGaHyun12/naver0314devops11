package data.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.Dto.ShopDto;
import db.Common.MySqlConnect;

public class ShopDao {
    MySqlConnect connect=new MySqlConnect();

    public void insertShop(ShopDto dto)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;

        String sql="insert into myshop (sname,sprice,scount,scolor,sphoto,writeday) values (?,?,?,?,?,now())";
        conn=connect.getConnection();//db 연결
        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getSname());
            pstmt.setInt(2, dto.getSprice());
            pstmt.setInt(3, dto.getScount());
            pstmt.setString(4, dto.getScolor());
            pstmt.setString(5, dto.getSphoto());
            //실행
            pstmt.execute();

        } catch (SQLException e) {
            System.out.println("insert 오류:"+e.getMessage());
        }finally {
            connect.dbClose(pstmt, conn);
        }

    }

    public List<ShopDto> getShopDatas()
    {
        List<ShopDto> list=new Vector<ShopDto>();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from myshop order by shopidx desc";

        conn=connect.getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()) {
                ShopDto dto=new ShopDto();
                //db 에서 가져와서 dto에 넣기
                dto.setShopidx(rs.getString("shopidx"));
                dto.setSname(rs.getString("sname"));
                dto.setSprice(rs.getInt("sprice"));
                dto.setScount(rs.getInt("scount"));
                dto.setScolor(rs.getString("scolor"));
                dto.setSphoto(rs.getString("sphoto"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                //list 추가
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("select 오류:"+e.getMessage());
        }finally {
            connect.dbClose(rs, pstmt, conn);
        }

        return list;
    }

    public ShopDto getSangpum(int shopidx)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from myshop where shopidx=?";

        ShopDto dto=new ShopDto();

        conn=connect.getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, shopidx);
            //실행
            rs=pstmt.executeQuery();
            if(rs.next()) {
                dto.setShopidx(rs.getString("shopidx"));
                dto.setSname(rs.getString("sname"));
                dto.setSprice(rs.getInt("sprice"));
                dto.setScount(rs.getInt("scount"));
                dto.setScolor(rs.getString("scolor"));
                dto.setSphoto(rs.getString("sphoto"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connect.dbClose(rs, pstmt, conn);
        }

        return dto;

    }

    //수정
    public void updateShop(ShopDto dto){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="update myshop set sname=?,scolor=?,sprice=?,scount=?,sphoto=? where shopidx=?";

        try{
            conn=connect.getConnection(); // 데이터베이스 연결 가져오기
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getSname());
            pstmt.setString(2, dto.getScolor());
            pstmt.setInt(3, dto.getSprice());
            pstmt.setInt(4, dto.getScount());
            pstmt.setString(5, dto.getSphoto());
            pstmt.setString(6, dto.getShopidx());
            //실행
            pstmt.executeUpdate(); // executeUpdate를 사용하여 쿼리를 실행합니다.
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connect.dbClose(pstmt, conn);
        }
    }

    //삭제
    public void deleteShop(ShopDto dto){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="delete from myshop where shopidx=?";

        try{
            conn=connect.getConnection(); // 데이터베이스 연결 가져오기
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getShopidx());
            //실행
            pstmt.executeUpdate(); // executeUpdate를 사용하여 쿼리를 실행합니다.
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connect.dbClose(pstmt, conn);
        }
    }


}