package model.entities;

public class User {
    private static String username;
    private static Role role;

    public static void setUsername(String username) {
        User.username = username;
    }

    public static void setRole(int i) {
        if (i == 0) {
            role = Role.User;
        }
        else{
            role = Role.Admin;
        }
    }

    public static String getUsername() {
        return username;
    }

    public static boolean isAdmin() {
        if (role == Role.Admin) {
            return true;
        }
        return false;
    }

    public static void setRole(Role role) {
        User.role = role;
    }
}
