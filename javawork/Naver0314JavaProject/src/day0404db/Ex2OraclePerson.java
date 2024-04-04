package day0404db;

import java.sql.*;

public class Ex2OraclePerson {
    static final String ORACLE_DRIVER="oracle.jdbc.OracleDriver";
    static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521/xe";
    static final String USERNAME="angel";
    static final String PASSWORD="a1234";
    public Ex2OraclePerson(){
        try{
            Class.forName(ORACLE_DRIVER);
            System.out.println("오라클 드라이버 성공!");
        }catch (ClassNotFoundException e){
            System.out.println("오라클 드라이버 실패:"+e.getMessage());
        }
    }
    static public void showTitle(){
        System.out.println("=".repeat(40));
        System.out.println("시퀀스\t이름\t  혈액형 나이 \t입사일");
        System.out.println("=".repeat(40));
    }
    public void writePerson()
    {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String sql="select pnum,pname,upper(pblood) pblood,page,to_char(ipasaday,'yyyy-mm-dd') ipsaday from person";
        try {
            conn = DriverManager.getConnection(ORACLE_URL, USERNAME, PASSWORD);
            System.out.println("ORACLE 서버에 연결 성공!");

            showTitle();

            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);

            while (rs.next()){
                String pnum=rs.getString("pnum");
                String pname=rs.getString("pname");
                String pblood=rs.getString("pblood");
                int page=rs.getInt("page");
                String ipsaday=rs.getString("ipsaday");

                System.out.println(" "+pnum+"\t\t"+pname+"\t"+pblood+"  "+page+"세\t"+ipsaday);
            }

        }catch (SQLException e){
            System.out.println("오라클 서버 연결 실패:"+e.getMessage());
        }finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args){
        Ex2OraclePerson ex2=new Ex2OraclePerson();
        ex2.writePerson();
    }
}
