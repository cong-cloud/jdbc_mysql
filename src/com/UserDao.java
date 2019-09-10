package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wang
 * @version 2.0
 * @company 东方标准
 * @date 2019/9/10 12:24
 * @decription
 */
public class UserDao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
//        List<User> list = select();
////        for (User user : list) {
////            System.out.println(user);
////        }

        User user = new User(4, "bbb", "111");
//        save(user);
//        update(user);
//        delete(user);
    }

    public static void delete(User user) {
        Connection conn = null;
        PreparedStatement stat = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "delete from user where id=?";
            stat = conn.prepareStatement(sql);
            stat.setObject(1, user.getId());
            stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void update(User user) {
        Connection conn = null;
        PreparedStatement stat = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "update user set name=? ,password=? where id=?";
            stat = conn.prepareStatement(sql);
            stat.setObject(1, user.getName());
            stat.setObject(2, user.getPassword());
            stat.setObject(3, user.getId());
            stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void save(User user) {
        Connection conn = null;
        PreparedStatement stat = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "insert into user (id,name,password) values(null,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setObject(1, user.getName());
            stat.setObject(2, user.getPassword());
            stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<User> select() {
        List<User> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stat = null;
        try {
            //注册数据库驱动
            Class.forName(DRIVER);
            //获取连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "select * from user";
            //实例化PreparedStatement对象
            stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                User user = new User();
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String ps = rs.getString("password");
                user.setId(id);
                user.setName(name);
                user.setPassword(ps);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭连接
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
