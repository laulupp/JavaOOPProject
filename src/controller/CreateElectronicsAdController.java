package controller;

import model.CreateElectronicsAdModel;
import model.HomeModel;
import view.CreateElectronicsAdView;
import view.HomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateElectronicsAdController {
    private CreateElectronicsAdModel model;
    private CreateElectronicsAdView view;

    public CreateElectronicsAdController(CreateElectronicsAdModel model, CreateElectronicsAdView view) {
        this.model = model;
        this.view = view;
        view.addBackListener(new BackAd());
        view.addAlertListener(new AlertAd());
        view.addSubmitListener(new SubmitAd());
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
            if(!model.checkNumber(view.getEnergyConsumption())){
                view.setError("E. Consumption should be a number");
                return;
            }
            view.addedSuccessfully();
            model.insertElectronics();
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
