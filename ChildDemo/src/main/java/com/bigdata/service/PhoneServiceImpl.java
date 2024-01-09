package com.bigdata.service;

import com.bigdata.DB.JDBCUtil;
import com.bigdata.pojo.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maomao
 * @date 2024/1/8 18:45
 * @description PhoneServiceImpl
 */

public class PhoneServiceImpl implements PhoneService{
    @Override
    public List<Phone> queryAll(){
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        String sql = "select number,sex,age from phone";
        List<Phone> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnect();
            psm = conn.prepareStatement(sql);
            rs = psm.executeQuery();
            while (rs.next()){
                Phone phone = new Phone();
                phone.setNumber(rs.getString("number"));
                phone.setSex(rs.getString("sex"));
                phone.setAge(rs.getInt("age"));
                list.add(phone);
            }
            JDBCUtil.close(conn, psm, rs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Phone queryByPhone(String number) {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        Phone phone = new Phone();
        String sql = "select * from phone where number = ?";
        try {
            conn = JDBCUtil.getConnect();
            psm = conn.prepareStatement(sql);
            psm.setString(1,number);
            rs = psm.executeQuery();
            while (rs.next()){
                phone.setNumber(rs.getString("number"));
                phone.setSex(rs.getString("sex"));
                phone.setAge(rs.getInt("age"));
            }
            JDBCUtil.close(conn, psm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phone;
    }

    @Override
    public boolean add(Phone phone) {
        Connection conn = null;
        PreparedStatement psm = null;
        String sql = "insert into phone values(null,?,?,?)";
        boolean b = false;
        try {
            conn = JDBCUtil.getConnect();
            psm = conn.prepareStatement(sql);
            psm.setString(1,phone.getNumber());
            psm.setString(2,phone.getSex());
            psm.setInt(3,phone.getAge());
            if(psm.executeUpdate()==1){
                b=true;
            }else {
                b=false;
            }
            JDBCUtil.close(conn, psm);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return b;
    }

    @Override
    public boolean update(Phone phone,String number) {
        Connection conn = null;
        PreparedStatement psm = null;
        String sql = "update phone set number=?,sex=?,age=? where number=?";
        boolean b = false;
        try {
            conn = JDBCUtil.getConnect();
            psm = conn.prepareStatement(sql);
            psm.setString(1,phone.getNumber());
            psm.setString(2,phone.getSex());
            psm.setInt(3,phone.getAge());
            psm.setString(4,number);
            if(psm.executeUpdate()==1){
                b=true;
            }else {
                b=false;
            }
            JDBCUtil.close(conn, psm);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return b;
    }

    @Override
    public boolean delete(String number) {
        Connection conn = null;
        PreparedStatement psm = null;
        String sql = "delete from phone where number=?";
        boolean b = false;
        try {
            conn = JDBCUtil.getConnect();
            psm = conn.prepareStatement(sql);
            psm.setString(1,number);
            if(psm.executeUpdate()==1){
                b=true;
            }else {
                b=false;
            }
            JDBCUtil.close(conn, psm);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return b;
    }
}
