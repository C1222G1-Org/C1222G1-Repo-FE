package case_m3.ozone.controller;

import case_m3.ozone.service.loginService.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private LoginServiceImpl loginService = new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if (loginService.checkUsernameRetrive(username) == 0) {
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("usernameMessage","Username is already exists.");
            request.getRequestDispatcher("register/register.jsp?status=0").forward(request, response);
        }
        if (loginService.checkEmailRetrive(email) == 0) {
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("emailMessage","Email is already exists.");
            request.getRequestDispatcher("register/register.jsp?status=0").forward(request, response);
        }
        if (!password.equals(confirmPassword)) {
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("passwordMessage","Password not match.");
            request.getRequestDispatcher("register/register.jsp?status=0").forward(request, response);
        }
        else {
            loginService.saveAccountRegister(username, email, password);
            response.sendRedirect("/login?message=register");
        }
    }
}
