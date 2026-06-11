package com.kb.webapp_todo.todo.controller;

import com.kb.webapp_todo.todo.dto.TodoDTO;
import com.kb.webapp_todo.todo.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;


@WebServlet("/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/todo/list ..........");

        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
        request.setAttribute("todos", dtoList);

        request.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}