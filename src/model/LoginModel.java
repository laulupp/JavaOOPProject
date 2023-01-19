package model;

import model.dao.UserDao;
import model.entities.Role;
import model.entities.User;
import view.LoginView;

public class LoginModel {
    private LoginView view;
    private String username;
    private String password;
    private UserDao userDao = new UserDao();

    public String tryLogin() throws Exception {
        try {
            username = view.getUsername();
            password = view.getPassword();
            if (username.isEmpty() || password.isEmpty()) {
                return "Credentials missing";
            }
            if (!userDao.userExists(username)) {
                return "Username does not exist";
            }
            if (!userDao.hashPassword(password).equals(userDao.getHashedPassword(username))) {
                return "The password is incorrect";
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public LoginModel(LoginView loginView) {
        this.view = loginView;
    }

    public void setUser() {
        try {
            if (userDao.getLevel(username) == 1) {
                User.setRole(Role.Admin);
            } else {
                User.setRole(Role.User);
            }
            User.setUsername(username);
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
