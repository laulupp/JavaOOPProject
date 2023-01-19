package model.entities;

public class Car extends Ad implements CarI {
    private String model;
    private int power;
    private int engineCapacity;
    private int year;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Car(String description, String title, int price, String model, int power, int engineCapacity, int year, String owner, int id) {
        super(description, title, price, owner, id);
        this.model = model;
        this.power = power;
        this.engineCapacity = engineCapacity;
        this.year = year;
    }

    public Car(String description, String title, int price, String model, int power, int engineCapacity, int year, String owner) {
        super(description, title, price, owner);
        this.model = model;
        this.power = power;
        this.engineCapacity = engineCapacity;
        this.year = year;
    }

    @Override
    public int estimatePrice() {
        int price;
        if (model.equals("Volkswagen")) {
            price = 7500;
        } else if (model.equals("BMW")) {
            price = 12500;
        } else if (model.equals("Audi")) {
            price = 10000;
        } else if (model.equals("Mercedes")) {
            price = 15000;
        } else {
            price = 5000;
        }

        if (power > 150) {
            price += 2000;
        }
        if (engineCapacity > 2000) {
            price += 3000;
        }

        if (year > 2020) {
            price += 3500;
        } else if (year > 2015) {
            price += 1500;
        }
        return price;
    }

    public int estimatePrice(int discount) {
        return (100 - discount) * estimatePrice() / 100;
    }

    @Override
    public String getOwner() {
        return "Last owner of the car : " + super.getOwner();
    }

    @Override
    public int getPollutionStandard() {
        if (year > 2017) {
            return 6;
        } else if (year > 2009) {
            return 5;
        } else if (year > 2004) {
            return 4;
        } else if (year > 2001) {
            return 3;
        } else if (year > 1998) {
            return 2;
        } else if (year > 1996) {
            return 1;
        }
        return 0;
    }

    public int getPollutionStandard(int year, int engineCapacity) {
        if (year > 2017) {
            if (engineCapacity > 2500) {
                return 5;
            }
            return 6;
        } else if (year > 2009) {
            if (engineCapacity > 3000) {
                return 4;
            }
            return 5;
        } else if (year > 2004) {
            if (engineCapacity > 5000) {
                return 2;
            }
            return 4;
        } else if (year > 2001) {
            if (engineCapacity > 4000) {
                return 1;
            }
            return 3;
        } else if (year > 1998) {
            if (engineCapacity > 4000) {
                return 0;
            }
            return 2;
        } else if (year > 1996) {
            if (engineCapacity > 4000) {
                return 0;
            }
            return 1;
        }
        return 0;
    }

    public String getAdDetails() {
        return "Category : Cars, Owner : " + getOnlyOwner() + ", Id : " + getId();
    }

    public Object getOnlyOwner() {
        return super.getOwner();
    }
}
