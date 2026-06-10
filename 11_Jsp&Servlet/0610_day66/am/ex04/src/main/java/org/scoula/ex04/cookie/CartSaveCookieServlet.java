package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_save_cookie")
public class CartSaveCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        String product = req.getParameter("product");

        Cookie[] cookies = req.getCookies();
        Cookie c = null;

        if (cookies == null || cookies.length == 0) {
            c = new Cookie("product", product);
        } else {
            c = new Cookie("product" + (cookies.length + 1), product);
        }

        resp.addCookie(c);

        out.print("<html><body>");
        out.print("product 추가됨<br>");
        out.print("<a href='cookie_product.jsp'>상품 선택</a><br>");
        out.print("<a href='cart_view_cookie'>장바구니</a>");
        out.print("</body></html>");
    }
}
