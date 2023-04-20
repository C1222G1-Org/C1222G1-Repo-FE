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
        List<AccountUser> accountUserPostList = homeService.getAccountPostById(id);
        List<Comment> commentList =homeService.getListCommentByIdPost(id);
        List<AccountUser> accountUserCommentList = homeService.getAccountCommentById(id);
        request.setAttribute("post", post);
        request.setAttribute("userPost", accountUserPostList);
        request.setAttribute("commentList", commentList);
        request.setAttribute("userComment", accountUserCommentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("post/detail.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                showListSearchPost(request, response);
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

    private void showListSearchPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Post> postList = homeService.getListPostByName(search);
        request.setAttribute("postList", postList);
        if (postList.size() == 0) {
            request.setAttribute("message", "Post titled \"" + search+ "\" could not be found. Please try again.");
        }
        request.getRequestDispatcher("navigation/generalPost.jsp").forward(request, response);
    }
}
