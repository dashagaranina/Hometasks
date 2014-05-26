package task23;



import java.sql.*;

public class task25 {

    public static  Connection connection = null;
    public static PreparedStatement ptmt = null;
    public static ResultSet rs = null;

    public static void main (String args []) throws SQLException {
            String url = "jdbc:postgresql://localhost:5432/users";
            String user = "postgres";
            String pass = "qwerty";
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try{
                connection = DriverManager.getConnection(url, user, pass);
                connection.setAutoCommit(false);
               
                int idN = check();
                String name1 = "Book"+(idN+1);
                String name2 = "Book"+(idN+2);
                add(idN+1, 2, name1, 200);
                add(idN+2, 2, name2, 300);
Savepoint savepoint = connection.setSavepoint();
/*TODO Если во время обновления цен произойдет ошибка, данные о новых книгах должны остаться в БД. 
Используй для этого savepoint
*/
                idN = check();
                if (idN>10){
			choise(savepoint);
                    
                } 
                    
                
                connection.commit();
            } catch(Exception e ) {
                e.printStackTrace();
                if (connection != null) {
                    connection.rollback();
                }

            } finally {
                if(connection != null) {
                    connection.close();
                }
            }
    }

    public static boolean choise (Savepoint savepoint) {
        try {
            ptmt = connection.prepareStatement("SELECT id , price FROM books");
            rs = ptmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                update(id ,price);
		
            }
        } catch (SQLException e) {
            e.printStackTrace();
		connection.rollback(savepoint);
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

            ptmt.setDouble(1, price + 0.1*price);
            ptmt.setInt(2, id);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void add (int id, int author_id, String name, double price){
        try{
            ptmt = connection.prepareStatement("INSERT INTO books (id, author_id, title, price) VALUES (?,?,?,?)");
            ptmt.setInt(1, id);
            ptmt.setInt(2,author_id);
            ptmt.setString(3,name);
            ptmt.setDouble(4, price);
            boolean b = ptmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
            } catch (SQLException e) {
                    e.printStackTrace();
            }
        }
    }

    public static int check() {
        try {
            ptmt = connection.prepareStatement("SELECT COUNT(id) FROM books");
            rs = ptmt.executeQuery();
            if (rs.next()){
                int idN = rs.getInt(1);
                return idN;
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
        } return 0;
    }

}


