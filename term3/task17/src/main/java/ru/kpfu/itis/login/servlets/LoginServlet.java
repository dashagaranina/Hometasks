package ru.kpfu.itis.login.servlets;

import ru.kpfu.itis.login.dao.CredentialsDao;
import ru.kpfu.itis.login.dao.CredentialsDaoImpl;
import ru.kpfu.itis.login.model.Credentials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CredentialsDao credentialsDao = new CredentialsDaoImpl();

    @Override
    public void doPost (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean find = credentialsDao.findPass(username,password);
        if (find) {
            request.setAttribute("error",false);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/jsp/login.jsp").forward(request, response);
        } else {
            request.setAttribute("error",true);
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        }
    }
}

