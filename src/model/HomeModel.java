package model;

import model.dao.CarsDao;
import model.dao.ElectronicsDao;
import model.dao.OthersDao;
import model.entities.Car;
import model.entities.Electronics;
import model.entities.Others;
import model.entities.User;
import view.HomeView;

import java.util.ArrayList;

public class HomeModel {
    private HomeView view;
    private ArrayList<Car> cars = new ArrayList<Car>();
    private ArrayList<Electronics> electronics = new ArrayList<Electronics>();
    private ArrayList<Others> others = new ArrayList<Others>();

    private CarsDao carsDao = new CarsDao();
    private OthersDao othersDao = new OthersDao();
    private ElectronicsDao electronicsDao = new ElectronicsDao();

    private void getCars() throws Exception {
        cars = carsDao.getCars();
    }

    private void getElectronics() throws Exception {
        electronics = electronicsDao.getElectronics();
    }

    private void getOthers() throws Exception {
        others = othersDao.getOthers();
    }

    public void displayCars() throws Exception {
        getCars();
        for (Car i : cars) {
            System.out.println(i.getAdDetails());
            if (i.getOnlyOwner().equals(User.getUsername()) || User.isAdmin()) {
                view.addCarToPanel(i, true);
            } else {
                view.addCarToPanel(i, false);
            }
        }
    }

    public HomeModel(HomeView view) {
        this.view = view;
        if(User.isAdmin()){
            view.setAdminInterface();
        }
    }

    public void deleteElectronics(int id) throws Exception{
        electronicsDao.deleteElectronics(id);
    }
    public void deleteCar(int id) throws Exception{
        carsDao.deleteCar(id);
    }
    public void displayElectronics() throws Exception {
        getElectronics();
        for (Electronics e : electronics) {
            System.out.println(e.getAdDetails());
            if (e.getOwner().equals(User.getUsername()) || User.isAdmin()) {
                view.addElectronicsToPanel(e, true);
            } else {
                view.addElectronicsToPanel(e, false);
            }
        }
    }
    public void setUsername(String username, int role){
        User.setUsername(username);
        User.setRole(role);
    }
    public void displayOthers() throws Exception {
        getOthers();
        for (Others o : others) {
            System.out.println(o.getAdDetails());
            if (o.getOwner().equals(User.getUsername()) || User.isAdmin()) {
                view.addOthersToPanel(o, true);
            } else {
                view.addOthersToPanel(o, false);
            }
        }
    }

    public void deleteOthers(int id) throws Exception{
        othersDao.deleteOthers(id);
    }
}
