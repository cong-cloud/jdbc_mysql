package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wang
 * @version 2.0
 * @company 东方标准
 * @date 2019/9/10 17:29
 * @decription
 */
public class DbUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void getConn() {
        Connection conn = null;
        try {
            Class.forName(URL);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("连接数据库加载驱动失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接数据库获取连接失败！");
            e.printStackTrace();

        }

    }

    public static void getStatement() {

    }
}
