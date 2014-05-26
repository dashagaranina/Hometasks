package ru.kpfu.itis.login.servlets;

import ru.kpfu.itis.login.dao.CredentialsDao;
import ru.kpfu.itis.login.dao.CredentialsDaoImpl;
import ru.kpfu.itis.login.model.Credentials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CredentialsDao credentialsDao = new CredentialsDaoImpl();

    @Override
    public void doPost (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String salt = credentialsDao.findSalt(username);
        String pass = createPasSalt(password,salt);
        String hashpass = MD5(pass);
        String fio = credentialsDao.findFio(username);
        String date = credentialsDao.findDate(username);
        String group = credentialsDao.findGroup(username);
        String lab = credentialsDao.findLab(username);
        String activity = credentialsDao.findActivity(username);
        boolean find = credentialsDao.findPass(username,hashpass);
        if (find) {
            request.setAttribute("error",false);

            request.setAttribute("fio", fio);
            request.setAttribute("date", date);
            request.setAttribute("group", group);
            request.setAttribute("lab", lab);
            request.setAttribute("activity", activity);
            request.getSession().setAttribute("session_uname", username);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/jsp/login.jsp").forward(request, response);


        } else {
            request.setAttribute("error",true);
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        }




    }


    public String createPasSalt (String password, String salt) {
        String pass = password+salt;

        return pass;
    }

    public String MD5(String pass) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(pass.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}

