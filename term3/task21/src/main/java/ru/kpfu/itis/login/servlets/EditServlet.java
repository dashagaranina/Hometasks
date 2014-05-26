package ru.kpfu.itis.login.servlets;

import ru.kpfu.itis.login.dao.CredentialsDao;
import ru.kpfu.itis.login.dao.CredentialsDaoImpl;
import ru.kpfu.itis.login.model.Credentials;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: GaranDasha
 * Date: 09.11.13
 * Time: 0:50
 * To change this template use File | Settings | File Templates.
 */
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    CredentialsDao credentialsDao = new CredentialsDaoImpl();

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher(
                "/jsp/edit.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Credentials credentials = new Credentials();
        credentials = (Credentials)request.getSession().getAttribute("current_user");

        credentials.setFio(request.getParameter("fio"));
        credentials.setDate(request.getParameter("date"));
        credentials.setGroup(request.getParameter("group"));
        credentials.setLab(request.getParameter("lab"));
        credentials.setActivity(request.getParameter("activity"));
        credentialsDao.update(credentials);
        request.setAttribute("credentials", credentials);


        getServletConfig().getServletContext().getRequestDispatcher(
                "/jsp/login.jsp").forward(request, resp);
    }
}
