package case_m3.ozone.service.homeService;

import case_m3.ozone.model.AccountUser;
import case_m3.ozone.model.Comment;
import case_m3.ozone.model.Post;
import case_m3.ozone.repository.homeRepository.HomeRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class HomeServiceImpl implements  IHomeService{
    private static HomeRepositoryImpl homeRepository = new HomeRepositoryImpl();
    @Override
    public List<Post> getAllPost() throws SQLException {
        return homeRepository.getAllPost();
    }

    @Override
    public List<Post> getListPostByName(String name) {
        return homeRepository.getListPostByName(name);
    }

    @Override
    public List<Post> getListNewPost() {
        return homeRepository.getListNewPost();
    }

    @Override
    public Post getPostById(int id) throws SQLException {
        return homeRepository.getPostById(id);
    }

    @Override
    public List<Comment> getListCommentByIdPost(int id) {
        return homeRepository.getListCommentByIdPost(id);
    }

    @Override
    public List<Comment> getListComment() {
        return homeRepository.getListComment();
    }

    public List<AccountUser> getAccountPostById(int id) {
        return homeRepository.getAccountPostById(id);
    }

    public List<AccountUser> getAccountCommentById(int id) {
        return homeRepository.getAccountCommentById(id);
    }
}
