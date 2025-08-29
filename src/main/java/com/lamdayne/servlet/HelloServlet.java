package com.lamdayne.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = {"/hello", "/test"}, initParams = {
//        @WebInitParam(name = "name", value = "Hello")
//})
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Bắt đầu Servlet");
    }

    @Override
    public void destroy() {
        System.out.println("Exit");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        System.out.println("Phuong thuc cua request : " + req.getMethod());
        System.out.println("Server: " + req.getServerName());
        System.out.println(req.getServletPath());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = super.getServletConfig().getInitParameter("name");

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Servlet Basic</h1>");
        writer.println("Xin chao: " + name);

        writer.println(getServletConfig().getServletName());

        writer.close();
    }
}
