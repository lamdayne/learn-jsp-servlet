package com.lamdayne.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/form-person"})
public class FormPerson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.println("<form action='/learn-jsp-servlet/add-user' method='POST'>");
        writer.println("Ten <input type='text' name='name'>");
        writer.println("Tuoi <input type='number' name='age'>");
        writer.println("Dia chi <input type='text' name='address'>");
        writer.println("<button type='submit' value='submit'>Submit</button>");
        writer.println("<form>");
    }
}
