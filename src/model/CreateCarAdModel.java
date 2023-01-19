package model;

import model.dao.CarsDao;
import model.entities.Car;
import model.entities.User;
import view.CreateCarAdView;

public class CreateCarAdModel {
    private CreateCarAdView view;
    private CarsDao carsDao = new CarsDao();
    public boolean checkNonEmptyStrings() {
        if (view.getDescription().isEmpty() || view.getTitle().isEmpty() || view.getPrice().isEmpty() || view.getModel().isEmpty() || view.getEngineCapacity().isEmpty() || view.getPower().isEmpty() || view.getYear().isEmpty()) {
            return false;
        }
        return true;
    }
    public boolean checkNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public void insertCar(){
        try{
            carsDao.insertCar(new Car(view.getDescription(), view.getTitle(), Integer.parseInt(view.getPrice()),
                view.getModel(), Integer.parseInt(view.getPower()), Integer.parseInt(view.getEngineCapacity()),
                Integer.parseInt(view.getYear()), User.getUsername()));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public CreateCarAdModel(CreateCarAdView view){
        this.view = view;
    }
}
