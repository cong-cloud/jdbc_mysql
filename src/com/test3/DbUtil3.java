package com.test3;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author wang
 * @version 2.0
 * @company 东方标准
 * @date 2019/9/10 17:29
 * @decription
 */
public class DbUtil3 {

    private static String driver = "";
    private static String url = "";
    private static String user = "";
    private static String password = "";

    static {
        try {
            Properties properties = new Properties();
            properties.load(DbUtil3.class.getResourceAsStream("/db.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return java.sql.Connection
     * @date 2019/9/11
     * @description 获取连接
     */
    public static Connection getConn() {
        DbUtil3 dbUtil = new DbUtil3();
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("连接数据库加载驱动失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接数据库获取连接失败！");
            e.printStackTrace();

        }
        return conn;

    }

    /**
     * @param [resultSet, state, conn]
     * @return void
     * @date 2019/9/11
     * @description 关闭资源
     */
    public static void close(ResultSet resultSet, PreparedStatement state, Connection conn) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (state != null) {
                state.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("关闭失败！");
            e.printStackTrace();
        }

    }

}
