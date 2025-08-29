package com.lamdayne.controller.admin.api;

import com.google.gson.Gson;
import com.lamdayne.model.User;
import com.lamdayne.service.UserService;
import com.lamdayne.service.impl.UserServiceImpl;
import com.lamdayne.util.HttpUtil;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/api/admin/user"})
public class UserAPI extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        User user = HttpUtil.of(req.getReader()).toModel(User.class);
        user = userService.create(user);
        Gson gson = new Gson();
        gson.toJson(user);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(user));
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        User user = HttpUtil.of(req.getReader()).toModel(User.class);
        userService.update(user);
        user = userService.findOne(user.getUserID());
        Gson gson = new Gson();
        gson.toJson(user);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(user));
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        User user = HttpUtil.of(req.getReader()).toModel(User.class);
        userService.deleteById(user.getUserID());
        user = userService.findOne(user.getUserID());
        Gson gson = new Gson();
        gson.toJson(user);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(user));
        out.flush();
    }
}
