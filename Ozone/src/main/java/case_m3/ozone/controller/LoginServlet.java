package case_m3.ozone.controller;

import case_m3.ozone.model.AccountUser;
import case_m3.ozone.service.loginService.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private LoginServiceImpl loginService = new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login/form-login.jsp");

        request.setAttribute("message",  request.getParameter("message"));
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountUser accountUser = loginService.checkAccountUser(username, password);
        if (accountUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("account", accountUser);
            response.sendRedirect("home");
        } else {
            request.setAttribute("message", "Incorrect username or password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login/form-login.jsp");
            dispatcher.forward(request, response);
        }
    }
}

