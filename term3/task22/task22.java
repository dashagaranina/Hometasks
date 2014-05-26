
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class task22{
    static Connection con = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    public static void Select1a() throws SQLException{
        pst = con.prepareStatement("SELECT * FROM authors WHERE name LIKE 'N%' or name LIKE 'S%'");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }
    public static void Select1b() throws SQLException{
        pst = con.prepareStatement("SELECT * FROM books WHERE price>1000'");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }

    public static void Select2() throws SQLException{
        pst = con.prepareStatement("SELECT a.name, b.title FROM authors a, books b WHERE a.id=b.author_id");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }

    public static void Select3a() throws SQLException{
        pst = con.prepareStatement("SELECT MIN(price) FROM books");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }

    public static void Select3b() throws SQLException{
        pst = con.prepareStatement("SELECT AVG(price) FROM books");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }

    public static void Select3c() throws SQLException{
        pst = con.prepareStatement("SELECT COUNT(*) FROM authors");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }

    public static void Select4a() throws SQLException{
        pst = con.prepareStatement("SELECT MAX(b.price),a.name FROM authors a, books b WHERE a.id=b.author_id GROUP BY b.author_id,a.name");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }

    public static void Select4b() throws SQLException{
        pst = con.prepareStatement("SELECT COUNT(id) as amount,title FROM books GROUP BY title");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }

    public static void Select5a() throws SQLException{
        pst = con.prepareStatement("SELECT COUNT(name) FROM authors GROUP BY name HAVING COUNT(name)>1");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
        }

    public static void Select5b() throws SQLException{
        pst = con.prepareStatement("SELECT a.name, AVG(b.price) FROM authors a, books b GROUP BY b.author_id,a.name HAVING AVG(price)>1000");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }

    public static void Select5c() throws SQLException{
        pst = con.prepareStatement("SELECT a.name FROM authors a, books b WHERE a.id=b.author_id AND  b.price = (SELECT MAX(price) FROM books)");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }
    public static void Select5d() throws SQLException{
        pst = con.prepareStatement("SELECT a.name FROM authors a,books b WHERE a.id=b.author_id GROUP BY b.author_id,a.name HAVING COUNT(*)>1");
        rs = pst.executeQuery();

        while (rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(": ");
            System.out.println(rs.getString(2));
        }
    }

    public static void main(String[] args) {



        String url = "jdbc:postgresql://localhost/25432/Sonya14";
        String user = "postgres";
        String password = "postgres";

        try {

            con = DriverManager.getConnection(url, user, password);
            Select1a();
            Select1b();
            Select2();
            Select3a();
            Select3b();
            Select3c();
            Select4a();
            Select4b();
            Select5a();
            Select5b();
            Select5c();
            Select5d();


        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Retrieve.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Retrieve.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}