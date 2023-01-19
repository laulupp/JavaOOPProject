package model;

import model.dao.ElectronicsDao;
import model.entities.Electronics;
import model.entities.User;
import view.CreateElectronicsAdView;

public class CreateElectronicsAdModel {
    private CreateElectronicsAdView view;
    private ElectronicsDao electronicsDao = new ElectronicsDao();
    public boolean checkNonEmptyStrings() {
        if (view.getDescription().isEmpty() || view.getTitle().isEmpty() || view.getPrice().isEmpty() || view.getEnergyConsumption().isEmpty()) {
            return false;
        }
        return true;
    }

    public void insertElectronics() {
        try {
            electronicsDao.insertElectronics(new Electronics(view.getDescription(), view.getTitle(), Integer.parseInt(view.getPrice()),
                    Integer.parseInt(view.getEnergyConsumption()), User.getUsername()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean checkNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public CreateElectronicsAdModel(CreateElectronicsAdView view) {
        this.view = view;
    }
}
