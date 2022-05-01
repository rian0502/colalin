package com.belajar.colalin.accountView.Sessions;

public class UserLogged {
    private String user;
    private int id;

    public UserLogged(String user, int id) {
        this.user = user;
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

}
