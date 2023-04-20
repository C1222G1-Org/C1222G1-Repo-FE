package case_m3.ozone.service.homeService;

import case_m3.ozone.model.AccountUser;
import case_m3.ozone.model.Comment;
import case_m3.ozone.model.Post;

import java.sql.SQLException;
import java.util.List;

public interface IHomeService {
    List<Post> getAllPost() throws SQLException;
    List<Post> getListPostByName(String name);
    List<Post> getListNewPost();
    Post getPostById(int id) throws SQLException;
    List<Comment> getListCommentByIdPost(int id);
    List<Comment> getListComment();
    List<AccountUser> getAccountPostById(int id);
    List<AccountUser> getAccountCommentById(int id);
}
