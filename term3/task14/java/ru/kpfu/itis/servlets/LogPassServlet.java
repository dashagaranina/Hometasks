package ru.kpfu.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogPassServlet extends HttpServlet {
    Map<String, String> users;

    public void init() {
        users = new HashMap<String, String>();
        users.put("lolipop", "12345");
        users.put("qwerty", "qwerty");
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        String pass = users.get(username);
        if (pass.equals(password)) {
            request.setAttribute("error",false);


            getServletConfig().getServletContext().getRequestDispatcher(
                    "/jsp/profile.jsp").forward(request, response);
        } else {
            request.setAttribute("error",true);
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        }

    }
}