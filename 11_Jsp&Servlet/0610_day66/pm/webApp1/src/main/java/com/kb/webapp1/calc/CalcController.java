package com.kb.webapp1.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 사용자가 입력한 숫자의 처리는 POST 방식으로 전송
// name이 calcController이고, urlPatterns이 '/calc'인 서블릿
@WebServlet(name = "calcController", urlPatterns = "/calc")
public class CalcController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.printf("  num1 : %s\n", num1);
        System.out.printf("  num2 : %s\n", num2);
        System.out.printf("  %s + %s = %d\n", num1, num2, Integer.parseInt(num1) + Integer.parseInt(num2));

        resp.sendRedirect("/index.jsp");
    }
}
