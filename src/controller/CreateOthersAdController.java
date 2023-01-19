package controller;

import model.CreateOthersAdModel;
import model.HomeModel;
import view.CreateOthersAdView;
import view.HomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateOthersAdController {
    private CreateOthersAdView view;
    private CreateOthersAdModel model;

    public CreateOthersAdController(CreateOthersAdModel model, CreateOthersAdView view) {
        this.view = view;
        this.model = model;
        view.addBackListener(new CreateOthersAdController.BackAd());
        view.addAlertListener(new CreateOthersAdController.AlertAd());
        view.addSubmitListener(new CreateOthersAdController.SubmitAd());
    }
    class SubmitAd implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!model.checkNonEmptyStrings()) {
                view.setError("Please complete all fields");
                return;
            }
            if(!model.checkNumber(view.getPrice())){
                view.setError("Price should be a number");
                return;
            }
            view.addedSuccessfully();
            model.insertOthers();
        }
    }
    class AlertAd implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            view.getAlert().setVisible(false);
            view.getAlert().dispose();
            HomeView homeView = new HomeView();
            HomeModel homeModel = new HomeModel(homeView);
            HomeController homeController = new HomeController(homeModel, homeView);
            view.setVisible(false);
            view.dispose();
            homeView.setVisible(true);
        }
    }
    class BackAd implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            HomeView homeView = new HomeView();
            HomeModel homeModel = new HomeModel(homeView);
            HomeController homeController = new HomeController(homeModel, homeView);
            view.setVisible(false);
            view.dispose();
            homeView.setVisible(true);
        }
    }

}
