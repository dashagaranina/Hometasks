package ru.kpfu.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

            String username1 = request.getParameter("username1");
            String username2 = request.getParameter("username2");
            int sum =  Integer.parseInt(username2) + Integer.parseInt(username1);

            request.setAttribute("message", "Sum=" + sum);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/jsp/hello.jsp").forward(request, response);

    }
}
