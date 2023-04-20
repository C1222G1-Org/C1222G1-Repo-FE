package case_m3.ozone.controller;

import case_m3.ozone.model.AccountUser;
import case_m3.ozone.model.Comment;
import case_m3.ozone.model.Post;
import case_m3.ozone.service.adminService.AdminServiceImpl;
import case_m3.ozone.service.homeService.HomeServiceImpl;
import case_m3.ozone.service.loginService.LoginServiceImpl;
import javafx.geometry.Pos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    private HomeServiceImpl homeService = new HomeServiceImpl();
    private LoginServiceImpl loginService = new LoginServiceImpl();
    private AdminServiceImpl adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        if (path == null) {
            path = "";
        }
        switch (path) {
            case "post":
                try {
                    handlePathPost(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "user":
                handlePathUser(request, response);
                break;
            default:
                showListUser(request, response);
                break;
        }
    }

    private void showListPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Post> postList = homeService.getAllPost();
        request.setAttribute("postList", postList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/listUser.jsp");
        dispatcher.forward(request, response);
    }

    private void handlePathPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFormPost(request, response);
                break;
            case "update":
                showUpdateFormPost(request, response);
                break;
            case "delete":
                try {
                    deletePost(request, response);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showListUser(request, response);
                break;
        }
    }

    private void showUpdateFormPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Post post = homeService.getPostById(id);
//        List<Comment> commentList = homeService.getListComment();
////        request.setAttribute("accountList", accountUserList);
//        request.setAttribute("commentList", commentList);
//        request.getRequestDispatcher("admin/formPost.jsp").forward(request, response);
    }

    private void showCreateFormPost(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        if (path == null) {
            path = "";
        }
        switch (path) {
            case "post":
                handleSubmitFormPost(request, response);
                break;
            case "user":
                handlePathUser(request, response);
                break;
            default:
                try {
                    showListPost(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void handlePathUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "update":
                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showListUser(request, response);
                break;
        }
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AccountUser> accountUserList = loginService.getListAccountUserInAdmin();
        request.setAttribute("accountUserList", accountUserList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/listUser.jsp");
        dispatcher.forward(request, response);
    }

    private void handleSubmitFormPost(HttpServletRequest request, HttpServletResponse response) {
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        loginService.deleteUser(id);
        response.sendRedirect("admin?path=user");
    }

    public void deletePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        adminService.deletePostById(id);
        response.sendRedirect("admin");
    }
}