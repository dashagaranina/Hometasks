package task23;

import org.postgresql.util.PSQLException;

import java.sql.*;


/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 14.11.13
 * Time: 1:34
 * To change this template use File | Settings | File Templates.
 */
public class task23 {
    public static String url = "jdbc:postgresql://localhost:5432/users";
    public static String user = "postgres";
    public static String pass = "qwerty";
    public static  Connection connection = null;
    public static PreparedStatement ptmt = null;
    public static ResultSet rs = null;



        public static void main (String args []) throws SQLException {
            try{
                connection = DriverManager.getConnection(url, user, pass);
                connection.setAutoCommit(false);
                choise();
                connection.commit();
            } catch(Exception e) {
                if (connection != null) {
                    connection.rollback();
                }
            } finally {
                if(connection != null) {
                    connection.close();
                }
            }
    }

    public static void choise () throws PSQLException{
        try {
            ptmt = connection.prepareStatement("SELECT id , price FROM books");
            rs = ptmt.executeQuery();
            while (rs.next()) {
                 int id = rs.getInt(1);
                 double price = rs.getInt(2);
                update(id ,price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void update (int id, double price) {
        try {

            String stm = "UPDATE books SET price=? WHERE id=?";
            ptmt = connection.prepareStatement(stm);
            if (id==2) {
                throw new RuntimeException();
            }
            ptmt.setDouble(1, price + 0.05*price);
            ptmt.setInt(2, id);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
        }

    }


