package com.test3;

import com.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author wang
 * @version 2.0
 * @company 东方标准
 * @date 2019/9/11 16:04
 * @decription
 */
public class UserDao3 {

    public static void main(String[] args) {
        select();
    }

    public static void select() {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            conn = DbUtil3.getConn();
            String sql = "select * from user";
            state = conn.prepareStatement(sql);
            rs = state.executeQuery();
            while (rs.next()) {
                User user = new User();
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String ps = rs.getString("password");
                user.setId(id);
                user.setName(name);
                user.setPassword(ps);
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil3.close(rs, state, conn);
        }

    }
}
