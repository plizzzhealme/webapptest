package io.github.plizzzhealme.web;

import io.github.plizzzhealme.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PutServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    //согласно мапингу этот сервлет будет работать при переходе по адресу /add
    //в PrintWriter записывается возвращаемая страница
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String data = request.getParameter("data");

        Service.addRecord(data);

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("Data: " + Service.readData());

        printWriter.close();
    }
}
