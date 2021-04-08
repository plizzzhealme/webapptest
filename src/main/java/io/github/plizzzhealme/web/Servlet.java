package io.github.plizzzhealme.web;

import io.github.plizzzhealme.entity.Poll;
import io.github.plizzzhealme.entity.User;
import io.github.plizzzhealme.service.SelectService;
import io.github.plizzzhealme.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(Servlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        LOGGER.info(req.getRequestURL() + "?" + req.getQueryString());

        String result;
        String parameter = req.getParameterNames().nextElement();
        SelectService selectService = ServiceFactory.getSelectService();

        if (parameter.equalsIgnoreCase("email")) {
            String email = req.getParameter("email");
            User user = selectService.getUser(email);
            result = user.toString();
        } else if (parameter.equalsIgnoreCase("question")){
            String question = req.getParameter("question");
            Poll poll = selectService.getPoll(question);
            result = poll.toString();
        } else {
            result = "Invalid parameter name";
        }

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(result);
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info(req.getRequestURL() + "?" + req.getQueryString());

        User user = new User();
        user.setEmail(req.getParameter("email"));
        user.setName(req.getParameter("name"));
        user.setSex(req.getParameter("sex"));

        ServiceFactory.getPostService().postUser(user);

        req.getRequestDispatcher("/").forward(req, resp);
    }
}
