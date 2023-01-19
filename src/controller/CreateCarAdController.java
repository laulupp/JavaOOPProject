package controller;

import model.CreateCarAdModel;
import model.HomeModel;
import view.CreateCarAdView;
import view.HomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCarAdController {
    private CreateCarAdView view;
    private CreateCarAdModel model;
    public CreateCarAdController(CreateCarAdModel model, CreateCarAdView view) {
        this.view = view;
        this.model = model;
        view.addSubmitListener(new SubmitAd());
        view.addAlertListener(new AlertAd());
        view.addBackListener(new BackAd());
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
            if(!model.checkNumber(view.getPower())){
                view.setError("Power should be a number");
                return;
            }
            if(!model.checkNumber(view.getEngineCapacity())){
                view.setError("E. Capacity should be a number");
                return;
            }
            if(!model.checkNumber(view.getYear())) {
                view.setError("Year should be a number");
                return;
            }
            view.addedSuccessfully();
            model.insertCar();
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
    class BackAd implements ActionListener{
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
