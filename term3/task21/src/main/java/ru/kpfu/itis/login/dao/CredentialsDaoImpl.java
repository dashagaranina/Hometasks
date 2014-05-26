package ru.kpfu.itis.login.dao;

import ru.kpfu.itis.login.dao.factory.ConnectionFactory;
import ru.kpfu.itis.login.model.Credentials;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            ptmt.setString(2, credentials.getUsername());
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
            String querystring = "UPDATE loginbd SET fio =?, date =?, group_n=?, lab=?, activity=? WHERE login = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, credentials.getFio());
            ptmt.setString(2, credentials.getDate());
            ptmt.setString(3, credentials.getGroup());
            ptmt.setString(4, credentials.getLab());
            ptmt.setString(5, credentials.getActivity());
            ptmt.setString(6, credentials.getUsername());

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
                credentials.setUsername(rs.getString(2));
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
            String querystring = "SELECT fio, date, group_n, lab, activity FROM credentials WHERE id = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setLong(1, id);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                credentials = new Credentials();
                credentials.setFio(rs.getString(1));
                credentials.setDate(rs.getString(2));
                credentials.setGroup(rs.getString(3));
                credentials.setLab(rs.getString(4));
                credentials.setActivity(rs.getString(5));
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

    public Credentials findPass(String username, String password, Credentials credentials) {
        try {
            String stm = "SELECT fio, date, group_n, lab, activity  FROM loginbd WHERE login=? AND password =?";
            con = getConnection();
            ptmt = con.prepareStatement(stm);
            ptmt.setString(1, username);
            ptmt.setString(2, password);
            rs = ptmt.executeQuery();
            boolean b = rs.next();
            if(b){
                String fio = rs.getString(1);
                credentials.setFio(fio);
                credentials.setDate(rs.getString(2));
                credentials.setGroup(rs.getString(3));
                credentials.setLab(rs.getString(4));
                credentials.setActivity(rs.getString(5));
                return credentials;
            }  else {       return null;}

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
        return null;
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

    public Credentials findFio (Credentials credentials) {
        try {
            String stm = "SELECT fio, date, group_n, lab, activity FROM loginbd WHERE login=?";
            con = getConnection();
            ptmt = con.prepareStatement(stm);
            ptmt.setString(1, credentials.getUsername());
            rs = ptmt.executeQuery();
            String res = null;
            boolean b = rs.next();
            if (b){
               credentials.setFio(rs.getString(1));
                credentials.setDate(rs.getString(2));
                credentials.setGroup(rs.getString(3));
                credentials.setLab(rs.getString(4));
                credentials.setActivity(rs.getString(5));


           }
            return credentials;
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


         }  return credentials;
    }
}
