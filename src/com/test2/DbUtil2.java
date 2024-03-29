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

    public static void getStateDQL() {

    }

    /**
     * @param [sql, obj]
     * @return java.sql.PreparedStatement
     * @date 2019/9/12
     * @description 添加，删除，修改
     */
    public static PreparedStatement getStateDML(String sql, Object... obj) {
        if (sql == null || sql == "") {
            return null;
        }
        PreparedStatement state = null;
        try {
            Connection conn = getConn();
            state = conn.prepareStatement(sql);
            if (obj != null) {
                int index = 1;
                for (Object o : obj) {
                    state.setObject(index, o);
                    index++;
                }
            }
            state.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return state;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement state, Connection conn) {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement state, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
