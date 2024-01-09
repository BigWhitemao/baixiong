package com.bigdata;


import org.junit.jupiter.api.*;

import java.sql.*;

/**
 * @author maomao
 * @date 2024/1/8 16:45
 * @description Test01
 */

public class Test01 {

    static Connection conn;
    static PreparedStatement psm;

    static ResultSet rs;


    @BeforeAll
    public static void getConnect() throws Exception {
        System.out.println("======================");
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3", "root", "123456");
    }

    @AfterAll
    public static void close() throws SQLException {
        conn.close();
        psm.close();
        rs.close();
        System.out.println("==============================");
    }

    @Test
    public void testAdd() throws Exception {
        String sql = "insert into student values(null,?,?)";
        psm = conn.prepareStatement(sql);
        psm.setString(1,"宝总");
        psm.setString(2,"1972-02-24");
        psm.execute();
    }

    @Test
    public void testUpdate() throws Exception{
        String sql = "update student set name = ? where id = ?";
        psm = conn.prepareStatement(sql);
        psm.setString(1,"汪小姐");
        psm.setInt(2,1);
        psm.execute();
    }

    @Test
    public void testDel() throws Exception{
        String sql = "delete from student where id = ?";
        psm = conn.prepareStatement(sql);
        psm.setInt(1,2);
        psm.execute();
    }

    @Test
    public void testQuery() throws Exception{
        String sql = "select * from student";
        psm = conn.prepareStatement(sql);
        rs = psm.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("id")+","+rs.getString("name")+","+rs.getString("birthday"));
        }
    }
}
