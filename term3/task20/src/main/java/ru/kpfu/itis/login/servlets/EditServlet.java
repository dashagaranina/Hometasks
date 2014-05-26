package ru.kpfu.itis.login.servlets;

import ru.kpfu.itis.login.dao.CredentialsDao;
import ru.kpfu.itis.login.dao.CredentialsDaoImpl;

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
        //String username = request.getSession().getAttribute("session_uname");
        String fio = request.getParameter("fio");
        String date = request.getParameter("date");
        String group = request.getParameter("group");
        String lab = request.getParameter("lab");
        String activity = request.getParameter("activity");
        String username = (String)request.getSession().getAttribute("session_uname");
        request.setAttribute("fio", fio);
        request.setAttribute("date", date);
        request.setAttribute("group", group);
        request.setAttribute("lab", lab);
        request.setAttribute("activity", activity);
        credentialsDao.update(username, fio, date, group, lab, activity);
        getServletConfig().getServletContext().getRequestDispatcher(
                "/jsp/login.jsp").forward(request, resp);
    }
}
