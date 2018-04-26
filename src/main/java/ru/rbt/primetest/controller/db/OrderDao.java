package ru.rbt.primetest.controller.db;

import ru.rbt.primetest.model.jdbc.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class OrderDao {
    public static ArrayList<OrderBean> getOrder() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("select * from BRM_ORDER");
            ArrayList<OrderBean> al = new ArrayList<OrderBean>();
            rs = ps.executeQuery();
            boolean found = false;
            while (rs.next()) {
                OrderBean e = new OrderBean();
                e.setID_PK(rs.getString("ID_PK"));
                e.setDATE_OF(rs.getString("DATE_OF"));
                e.setCUSTOMER_ID(rs.getString("CUSTOMER_ID"));
                al.add(e);
                found = true;
            }
            rs.close();
            if (found) {
                return al;
            } else {
                return null; // no entires found
            }
        } catch (Exception e) {
            System.out.println("Error In getOrder() -->" + e.getMessage());
            return (null);
        } finally {
            closeJdbc(con, ps, rs);
        }


    }
    private static void closeJdbc(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}