package ru.reeson2003.model;

/**
 * Created by Toshiba on 22.11.2016.
 */
public class User {
    private String login;
    private String password;
    int id;

    public User() {

    }

    public User(int id, String login, String password) {
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String result = new String("{id = " + id + ", login = " + login + ", password = " + password + "}");
        return result;
    }
}
