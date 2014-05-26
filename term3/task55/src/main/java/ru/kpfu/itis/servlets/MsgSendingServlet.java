package ru.kpfu.itis.servlets;

import com.oracle.jrockit.jfr.Producer;
import ru.kpfu.itis.Message;
import ru.kpfu.itis.dao.MsgDao;
import ru.kpfu.itis.dao.MsgDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MsgSendingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;



    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        MsgDao msgDao = new MsgDaoImpl();

        String message = request.getParameter("message");
        Message message1 = new Message(message);


        msgDao.add(message);
        System.out.println("fdfgfdg");
        getServletConfig().getServletContext().getRequestDispatcher(
                "/jsp/answer.jsp").forward(request, response);

    }



}
