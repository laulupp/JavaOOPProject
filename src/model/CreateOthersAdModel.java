package model;

import model.dao.OthersDao;
import model.entities.Electronics;
import model.entities.Others;
import model.entities.User;
import view.CreateOthersAdView;

public class CreateOthersAdModel {
    private CreateOthersAdView view;
    private OthersDao othersDao = new OthersDao();
    public boolean checkNonEmptyStrings() {
        if (view.getDescription().isEmpty() || view.getTitle().isEmpty() || view.getPrice().isEmpty() || view.getCategory().isEmpty()) {
            return false;
        }
        return true;
    }

    public void insertOthers() {
        try {
            othersDao.insertOthers(new Others(view.getDescription(), view.getTitle(), Integer.parseInt(view.getPrice()),
                    view.getCategory(), User.getUsername()));
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

    public CreateOthersAdModel(CreateOthersAdView view) {
        this.view = view;
    }
}
