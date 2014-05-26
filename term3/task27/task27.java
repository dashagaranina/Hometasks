package sample;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 30.10.13
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class task27 {
    public static void main (String args []) {
        Connection con = null;
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;

        String url = "jdbc:postgresql://localhost:5432/loginbd";
        String user = "postgres";
        String password = "qwerty";

        try {
            con = DriverManager.getConnection(url, user, password);

             //задание 1
            String stm = "SELECT name FROM employee WHERE job_title=(SELECT job_title FROM employee WHERE name='Виктор')";
            pst = con.prepareStatement(stm);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("1:"+rs.getString(1));

            }

            //задание 2

            stm = "SELECT employee.name, dept.city FROM employee, dept WHERE employee.dept_no=dept.id AND dept.city=(SELECT dept.city FROM dept, employee WHERE employee.name='Виктор' AND dept.id=employee.id)";
            pst = con.prepareStatement(stm);

            rs=pst.executeQuery();
 
            while (rs.next()) {
                System.out.println("2:"+rs.getString(1)+ " " + rs.getString(2));
            }
            //задание 3
            stm = "SELECT name FROM employee WHERE salary = (SELECT MIN(salary) FROM employee)";
            pst = con.prepareStatement(stm);
            rs=pst.executeQuery();
            while (rs.next()){
                System.out.println("3:" + rs.getString(1));
            }
            //задание 4
            stm = "SELECT name FROM employee WHERE job_title IN (SELECT job_title FROM employee, dept WHERE dept.name='sale' AND employee.dept_no=dept.id)";
            pst = con.prepareStatement(stm);
            rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("4: "+rs.getString(1) );
            }

            //задание 5
            stm= "SELECT name FROM employee WHERE dept_no IN (SELECT dept_no FROM employee WHERE job_title='аналитик')";
            pst = con.prepareStatement(stm);
            rs = pst.executeQuery();
            while (rs.next()){
                System.out.println("5: "+rs.getString(1));
            }

            //задание 6
            stm = "SELECT name FROM employee WHERE salary > (SELECT AVG (salary) FROM employee)";
            pst = con.prepareStatement(stm);
            rs = pst.executeQuery();
            while (rs.next()){
                System.out.println("6: "+rs.getString(1));
            }

            //задание 7
            stm = "SELECT COUNT(dept_no),dept.name FROM employee,dept WHERE dept.id=employee.dept_no AND job_title = 'аналитик' Group BY dept.id";
            pst = con.prepareStatement(stm);
            rs = pst.executeQuery();
            while (rs.next()){
                System.out.println("7: "+rs.getString(1)+" "+rs.getString(2));

            }

            //задание 8
            stm = "SELECT COUNT(dept_no), SUM(salary) FROM employee,dept WHERE (dept.id=employee.dept_no) Group BY dept.id, dept.id HAVING COUNT(employee.dept_no) > 2";
            pst = con.prepareStatement(stm);
            rs = pst.executeQuery();
            while (rs.next()){
                System.out.println("8: "+rs.getString(1)+" "+rs.getString(2));
            }

        }   catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Prepared.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }   finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Prepared.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }

        }

    }
}
