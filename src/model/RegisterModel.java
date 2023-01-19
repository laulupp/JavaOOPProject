package model;

import model.dao.UserDao;
import model.entities.Role;
import model.entities.User;
import view.RegisterView;

public class RegisterModel {
    private RegisterView view = new RegisterView();
    private String username;
    private String password;
    private String rePassword;
    private UserDao userDao = new UserDao();
    public RegisterModel(RegisterView registerView){
        this.view = registerView;
    }
    public void setUser() {
        User.setRole(Role.User);
        User.setUsername(username);
    }
    public String tryRegister() throws Exception {
        try {
            username = view.getUsername();
            password = view.getPassword();
            rePassword = view.getRePassword();
            if (username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                return "Please complete all fields";
            }
            if (userDao.userExists(username)) {
                return "Username already exists";
            }
            if (!password.equals(rePassword)) {
                return "Passwords don't match";
            }
            userDao.createUser(username, userDao.hashPassword(password));
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
