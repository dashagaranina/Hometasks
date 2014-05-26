package ru.kpfu.itis.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.kpfu.itis.login.model.Credentials;
import ru.kpfu.itis.login.dao.factory.ConnectionFactory;
import ru.kpfu.itis.login.model.Credentials;

public class CredentialsDaoImpl implements ru.kpfu.itis.login.dao.CredentialsDao {

    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    ResultSet rs1 = null;

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    public void add(Credentials credentials) {

        try {
            String querystring = "INSERT INTO credentials(id, login, password) VALUES (?, ?,?)";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setLong(1, credentials.getId());
            ptmt.setString(2, credentials.getLogin());
            ptmt.setString(3, credentials.getPassword());
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

    public void update(Credentials credentials) {
        try {
            String querystring = "UPDATE credentials SET login =?,password =? WHERE id = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);

            ptmt.setString(1, credentials.getLogin());
            ptmt.setString(2, credentials.getPassword());
            ptmt.setLong(3, credentials.getId());
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

    public void delete(Long id) {
        try {
            String querystring = "DELETE FROM credentials WHERE id =?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setLong(1, id);
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

    public List findAll() {
        List credentialss = new ArrayList();
        Credentials credentials = null;
        try {
            String querystring = "SELECT * FROM credentials";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                credentials = new Credentials();
                credentials.setId(rs.getLong(1));
                credentials.setLogin(rs.getString(2));
                credentials.setPassword(rs.getString(3));

                credentialss.add(credentials);
            }
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
        return credentialss;
    }

    public Credentials findByPrimaryKey(Long id) {
        Credentials credentials = null;
        try {
            String querystring = "SELECT * FROM credentials WHERE id = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setLong(1, id);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                credentials = new Credentials();
                credentials.setLogin(rs.getString(1));
                credentials.setPassword(rs.getString(2));
            }
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
        return credentials;
    }

    public boolean findPass(String username, String hashpass) {
        try {
            String stm = "SELECT login FROM loginbd WHERE login=? AND password =?";
            con = getConnection();
            ptmt = con.prepareStatement(stm);
            ptmt.setString(1, username);
            ptmt.setString(2, hashpass);
            rs = ptmt.executeQuery();
            boolean b = rs.next();
            System.out.println(b);
            return b;
            //return rs.next();
        }  catch (SQLException e) {
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
        return false;
    }

    public String findSalt (String username) {
        String salt = null;
         try {
             String stm = "SELECT salt FROM loginbd WHERE login=?";
             con = getConnection();
             ptmt = con.prepareStatement(stm);
             ptmt.setString(1, username);

             rs = ptmt.executeQuery();
                 if (rs.next()) {salt = rs.getString(1); }
             return salt;
         }    catch (SQLException e) {
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
        }return salt;
    }




}
