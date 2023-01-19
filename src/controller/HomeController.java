package controller;

import model.HomeModel;
import model.LoginModel;
import model.SelectAdTypeModel;
import view.HomeView;
import view.LoginView;
import view.SelectAdTypeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController {
    private HomeView view;
    private HomeModel model;

    public HomeController(HomeModel model, HomeView view) {
        this.model = model;
        this.view = view;
        view.addLogoutListener(new LogoutListener());
        view.addPlaceAdListener(new PlaceAdListener());
        try {
            System.out.println("Ads available :");//for debugging
            model.displayCars();
            model.displayElectronics();
            model.displayOthers();
            view.addDeleteListener(new DeleteAdListener());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class LogoutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setUsername("", 0);
            LoginView loginView = new LoginView();
            LoginModel loginModel = new LoginModel(loginView);
            LoginController loginController = new LoginController(loginModel, loginView);
            view.setVisible(false);
            view.dispose();
            loginView.setVisible(true);
        }
    }

    class PlaceAdListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SelectAdTypeView selectAdTypeView = new SelectAdTypeView();
            SelectAdTypeModel selectAdTypeModel = new SelectAdTypeModel(selectAdTypeView);
            SelectAdTypeController selectAdTypeController = new SelectAdTypeController(selectAdTypeModel, selectAdTypeView);
            view.setVisible(false);
            view.dispose();
            selectAdTypeView.setVisible(true);
        }
    }
    class DeleteAdListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getButtonId(e.getSource());
            int category = view.getButtonCategory(e.getSource());
            if(category == 0){
                try {
                    model.deleteCar(id);
                    view.deleteCarFromPanel(id);
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            } else if(category == 1){
                try {
                    model.deleteElectronics(id);
                    view.deleteElectronicsFromPanel(id);
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            } else {
                try {
                    model.deleteOthers(id);
                    view.deleteOthersFromPanel(id);
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
