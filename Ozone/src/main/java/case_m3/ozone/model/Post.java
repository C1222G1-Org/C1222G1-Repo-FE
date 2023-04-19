package case_m3.ozone.model;

import java.sql.Date;
import java.time.LocalDateTime;

public class Post {
    private int id;
    private String title;
    private  String content;
    private  int account;
    private Date postDate;

    public Post() {
    }

    public Post(int id, String title, String content, int account, Date postDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.account = account;
        this.postDate = postDate;
    }


    public Post(String title, String content, int account, Date postDate) {
        this.title = title;
        this.content = content;
        this.account = account;
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

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setUserName(String userName) {

    }
}
