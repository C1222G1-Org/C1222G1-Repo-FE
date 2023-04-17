package case_m3.ozone.repository.homeRepository;

import case_m3.ozone.model.AccountUser;
import case_m3.ozone.model.Comment;
import case_m3.ozone.model.Post;
import case_m3.ozone.repository.DBConnnection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomeRepositoryImpl implements IHomeRepository {
    private static final String SELECT_ALL_POST = "select * from post;";
    private static final String SELECT_POST_BY_ID = "select * from post where id_post = ?;";
    private static final String SELECT_ALL_NEW_POST = "select * from post order by date_post desc;";
    private static final String SELECT_COMMENT_BY_ID_POST = "select cm.id_comment, cm.content, account from comment as cm\n" +
            "join account as ac on ac.id_account = cm.id_account\n" +
            "join post as po on po.id_account = cm.id_account\n" +
            "where po.id_post = ?;";
    private final static String SELECT_ALL_COMMENT = "select * from comment as cm inner join account as ac on cm.id_account = ac.id_account  where id_account = ?";

    @Override
    public List<Post> getAllPost() {
        List<Post> actionPostList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_post");
                String title = resultSet.getString("title_post");
                String content = resultSet.getString("content_post");
                int account = resultSet.getInt("id_account");
                String username = resultSet.getString("username_post");
                Date datePost = resultSet.getDate("date_post");
                actionPostList.add(new Post(id, title, content, account, username, datePost));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.close();
        return actionPostList;
    }

    @Override
    public List<Post> getListPostByName(String name) {
        String query = "select * from post where title_post like concat('%', ?, '%');";
        List<Post> postList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_post");
                String title = resultSet.getString("title_post");
                String content = resultSet.getString("content_post");
                int account = resultSet.getInt("id_account");
                String username = resultSet.getString("username_post");
                Date datePost = resultSet.getDate("date_post");
                postList.add(new Post(id, title, content, account, username, datePost));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.close();
        return postList;
    }

    @Override
    public List<Post> getListNewPost() {
        List<Post> newPostList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NEW_POST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_post");
                String title = resultSet.getString("title_post");
                String content = resultSet.getString("content_post");
                int account = resultSet.getInt("id_account");
                String username = resultSet.getString("username_post");
                Date datePost = resultSet.getDate("date_post");
                newPostList.add(new Post(id, title, content, account, username, datePost));
            }
            DBConnection.close();
            return newPostList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Post getPostById(int id) {
        Post post = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POST_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title_post");
                String content = resultSet.getString("content_post");
                int account = resultSet.getInt("id_account");
                String username = resultSet.getString("username_post");
                Date datePost = resultSet.getDate("date_post");
                post = new Post(title, content, account, username, datePost);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return post;
    }

    @Override
    public List<Comment> getListCommentByIdPost(int id) {
        List<Comment> commentList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMENT_BY_ID_POST)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_comment = resultSet.getInt("cm.id_comment");
                String content_comment = resultSet.getString("cm.content_comment");
                int account = resultSet.getInt("cm.id_account");
                String username = resultSet.getString("username_comment");
                Date dateComment = resultSet.getDate("date_comment");
                commentList.add(new Comment(id_comment, content_comment, account, username, dateComment));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return commentList;
    }

//    @Override
//    public List<AccountUser> getAllAccount() {
//        List<AccountUser> accountUserList = new ArrayList<>();
//        try (Connection connection = DBConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id_account");
//                String username = resultSet.getString("username_account");
//                accountUserList.add(new AccountUser(id, username));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return accountUserList;
//    }

    public List<Comment> getListComment() {
        List<Comment> commentList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMMENT);
            {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_comment");
                    int idPost = resultSet.getInt("id_post");
                    int account = resultSet.getInt("id_account");
                    String content = resultSet.getString("content_comment");
                    String username = resultSet.getString("username_comment");
                    Date commentDate = resultSet.getDate("comment_date");
                    commentList.add(new Comment(id, idPost, content, account, username, commentDate));
                }
                DBConnection.close();
                return commentList;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}