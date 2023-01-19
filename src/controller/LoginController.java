package controller;

import model.HomeModel;
import model.LoginModel;
import model.RegisterModel;
import view.HomeView;
import view.LoginView;
import view.RegisterView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginController {
    private LoginModel model;
    private LoginView view;
    public LoginController(LoginModel model, LoginView view){
        this.model = model;
        this.view = view;

        view.addLoginListener(new LoginListener());
        view.addSendRegisterListener(new SendRegisterListener());
    }

    class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                String result = model.tryLogin();
                if(!result.equals("")) {
                    view.setError(result);
                }else{
                    model.setUser();
                    HomeView homeView = new HomeView();
                    HomeModel homeModel = new HomeModel(homeView);
                    HomeController homeController = new HomeController(homeModel, homeView);
                    view.setVisible(false);
                    view.dispose();
                    homeView.setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }
    class SendRegisterListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent mev){
            RegisterView registerView = new RegisterView();
            RegisterModel registerModel = new RegisterModel(registerView);
            RegisterController registerController = new RegisterController(registerModel, registerView);
            view.setVisible(false);
            view.dispose();
            registerView.setVisible(true);
        }
        public void mouseEntered(MouseEvent mev){
            view.setSendRegisterColor(new Color(70, 70, 70));
        }
        public void mouseExited(MouseEvent mev){
            view.setSendRegisterColor(new Color(100, 100, 100));
        }
        public void mousePressed(MouseEvent mev){
            view.setSendRegisterColor(new Color(40, 40, 40));
        }
        public void mouseReleased(MouseEvent mev){

        }
    }
}
