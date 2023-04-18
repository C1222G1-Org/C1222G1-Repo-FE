package case_m3.ozone.controller;

import case_m3.ozone.model.AccountUser;
import case_m3.ozone.model.Comment;
import case_m3.ozone.model.Post;
import case_m3.ozone.service.homeService.HomeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    private HomeServiceImpl homeService = new HomeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccountUser accountUser = (AccountUser) session.getAttribute("account");
        if (accountUser == null) {
            response.sendRedirect("login");
        }
        else {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "detail":
                    try {
                        showDetailPost(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
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
    }

    private void showListPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Post> postList = homeService.getAllPost();
        request.setAttribute("newPostList", postList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home/home.jsp");
        dispatcher.forward(request, response);
    }

    private void showDetailPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = homeService.getPostById(id);
        List<Comment> commentList =homeService.getListCommentByIdPost(id);
        request.setAttribute("post", post);
        request.setAttribute("commentList", commentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movies/detail.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
