package model.entities;

public class Electronics extends Ad{
    private int energyConsumption;

    public Electronics(String description, String title, int price, int energyConsumption, String owner) {
        super(description, title, price, owner);
        this.energyConsumption = energyConsumption;
    }
    public Electronics(String description, String title, int price, int energyConsumption, String owner, int id) {
        super(description, title, price, owner, id);
        this.energyConsumption = energyConsumption;
    }

    public int getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(int energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public String getAdDetails() {
        return "Category : Electronics, Owner : " + getOwner() + ", Id : " + getId();
    }
}
