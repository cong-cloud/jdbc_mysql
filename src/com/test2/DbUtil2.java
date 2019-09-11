package com.test2;

import java.sql.*;

/**
 * @author wang
 * @version 2.0
 * @company 东方标准
 * @date 2019/9/10 17:29
 * @decription
 */
public class DbUtil2 {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /**
     * @return java.sql.Connection
     * @date 2019/9/11
     * @description 获取连接
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
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
