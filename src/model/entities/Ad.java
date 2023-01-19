package model.entities;

abstract public class Ad {
    public abstract String getAdDetails();

    public Ad(String description, String title, int price, String owner) {
        this.description = description;
        this.title = title;
        this.price = price;
        this.owner = owner;
    }
    public Ad(String description, String title, int price, String owner, int id) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.price = price;
        this.owner = owner;
    }


    private String description;
    private String title;
    private int price;
    private String owner;
    private int id;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
