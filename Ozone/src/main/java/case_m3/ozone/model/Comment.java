package case_m3.ozone.model;

import java.sql.Date;

public class Comment {
    private int id;
    private int post;
    private  String content;
    private  int account;
    private Date commentDate;

    public Comment() {
    }

    public Comment(int id, int post, String content, int account, Date commentDate) {
        this.id = id;
        this.post = post;
        this.content = content;
        this.account = account;
        this.commentDate = commentDate;
    }

    public Comment(int id, String content, int account, Date commentDate) {
        this.id = id;
        this.content = content;
        this.account = account;
        this.commentDate = commentDate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
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


    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
