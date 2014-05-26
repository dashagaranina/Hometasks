package ru.kpfu.itis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import ru.kpfu.itis.dao.factory.ConnectionFactory;

public class MsgDaoImpl implements ru.kpfu.itis.dao.MsgDao {

    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    ResultSet rs1 = null;

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    public void add(String message) {

        try {
            String querystring = "INSERT INTO messages(msg) VALUES (?)";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, message);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}