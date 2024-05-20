package snack;

import db.common.MySqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SnackDao {
    MySqlConnect db = new MySqlConnect();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    // Method to retrieve all snacks from the database
    public List<SnackDto> getAllSnacks() {
        List<SnackDto> snacks = new ArrayList<>();
        String sql = "SELECT * FROM snack_info ";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SnackDto snack = new SnackDto();
                snack.setFood_cd(rs.getString("food_cd"));
                snack.setFood_nm(rs.getString("food_nm"));
                snack.setMfr_nm(rs.getString("MFR_NM")); // 수정된 부분)
                snacks.add(snack);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return snacks;
    }
    // Method to search for snacks by keyword in the database
    public SnackDto searchSnacks(String keyword) {
        SnackDto snack = null;
        String sql = "SELECT * FROM snack_info WHERE FOOD_NM = ?";

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, keyword);
            rs = ps.executeQuery();
            if (rs.next()) {
                snack = new SnackDto();
                snack.setFood_cd(rs.getString("food_cd"));
                snack.setFood_nm(rs.getString("food_nm"));
                snack.setKcal(rs.getInt("kcal"));
                snack.setProt(rs.getInt("prot"));
                snack.setFat(rs.getInt("fat"));
                snack.setTansu(rs.getInt("tansu"));
                snack.setSugar(rs.getInt("sugar"));
                snack.setSicke(rs.getInt("sicke"));
                snack.setCa(rs.getInt("ca"));
                snack.setNat(rs.getInt("nat"));
                snack.setChole(rs.getInt("chole"));
                snack.setServ_size(rs.getInt("serv_size"));
                snack.setMfr_nm(rs.getString("MFR_NM"));
                snack.setFood_size(rs.getDouble("FOOD_SIZE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, ps, conn);
        }
        return snack;
    }


}
