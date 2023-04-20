package case_m3.ozone.model;

import java.sql.Date;

public class PostDTO {
        private int id;
        private String title;
        private  String content;
        private  int account;
        private  String username;
        private int id_comment;
        private  String comment;
        private Date postDate;

    public PostDTO(int id, String title, String content, int account, String username, int id_comment, String comment, Date postDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.account = account;
        this.username = username;
        this.id_comment = id_comment;
        this.comment = comment;
        this.postDate = postDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
