package userfile;

public class User {

    private String userName;
    private int numberPosts = 0;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getNumberPosts() {
        return numberPosts;
    }

}
