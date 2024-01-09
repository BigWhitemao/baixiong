package com.bigdata.DB;

import java.sql.*;

/**
 * @author maomao
 * @date 2024/1/8 18:35
 * @description JDBCUtil
 */

public class JDBCUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3",
                    "root",
                    "123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    public static void close(Connection conn,PreparedStatement psm,ResultSet rs){
        try {
            if(rs != null){
                rs.close();
                rs=null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(psm != null){
                psm.close();
                psm=null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(conn != null){
                conn.close();
                conn=null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void close(Connection conn,PreparedStatement psm){
        try {
            if(psm != null){
                psm.close();
                psm=null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(conn != null){
                conn.close();
                conn=null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
