package com.lamdayne.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/add-user"})
public class PersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");

        writer.println("Ten " + name + " Tuoi " + age + " Dia chi " + address);
    }
}
