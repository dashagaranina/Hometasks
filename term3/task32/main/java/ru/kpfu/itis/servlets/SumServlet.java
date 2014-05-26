package ru.kpfu.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    int r;
    int h;
    int s;

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        int a;
        int b;
        Integer sum;

        String number1 = request.getParameter("num1");
        String number2 = request.getParameter("num2");

        a = Integer.parseInt(number1);
        b = Integer.parseInt(number2);
        sum = getSum(a, b);
        if (sum == null) {
            sum = a + b;

            synchronized (this) {
                r = a;
                h = b;
                s = sum;
            }
            request.setAttribute("message", "Sum = " + s);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/jsp/hello.jsp").forward(request, response);
        }

    }

    private Integer getSum(int a, int b) {
        synchronized (this) {
            if (r == a && h == b) {
                return s;
            }
            return null;
        }

    }
}