package controller;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectAdTypeController {
    private SelectAdTypeView view;
    private SelectAdTypeModel model;

    public SelectAdTypeController(SelectAdTypeModel model, SelectAdTypeView view) {
        this.model = model;
        this.view = view;
        view.addBackListener(new BackListener());
        view.addCreateListener(new CreateListener());
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            HomeView homeView = new HomeView();
            HomeModel homeModel = new HomeModel(homeView);
            HomeController homeController = new HomeController(homeModel, homeView);
            view.setVisible(false);
            view.dispose();
            homeView.setVisible(true);
        }
    }

    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println(view.getAdType());
            switch (view.getAdType()) {
                case 0:
                    CreateCarAdView createCarAdView = new CreateCarAdView();
                    CreateCarAdModel createCarAdModel = new CreateCarAdModel(createCarAdView);
                    CreateCarAdController createCarAdController = new CreateCarAdController(createCarAdModel, createCarAdView);
                    view.setVisible(false);
                    view.dispose();
                    createCarAdView.setVisible(true);
                    break;
                case 1:
                    CreateElectronicsAdView createElectronicsAdView = new CreateElectronicsAdView();
                    CreateElectronicsAdModel createElectronicsAdModel = new CreateElectronicsAdModel(createElectronicsAdView);
                    CreateElectronicsAdController createElectronicsAdController = new CreateElectronicsAdController(createElectronicsAdModel, createElectronicsAdView);
                    view.setVisible(false);
                    view.dispose();
                    createElectronicsAdView.setVisible(true);
                    break;
                default:
                    CreateOthersAdView createOthersAdView = new CreateOthersAdView();
                    CreateOthersAdModel createOthersAdModel = new CreateOthersAdModel(createOthersAdView);
                    CreateOthersAdController createOthersAdController = new CreateOthersAdController(createOthersAdModel, createOthersAdView);
                    view.setVisible(false);
                    view.dispose();
                    createOthersAdView.setVisible(true);
                    break;
            }


        }
    }

}
