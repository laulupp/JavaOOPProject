package model.entities;

public class Others extends Ad{
    public String Category;

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Others(String description, String title, int price, String category, String owner) {
        super(description, title, price, owner);
        Category = category;
    }
    public Others(String description, String title, int price, String category, String owner, int id) {
        super(description, title, price, owner, id);
        Category = category;
    }

    public String getAdDetails() {
        return "Category : Others, Owner : " + getOwner() + ", Id : " + getId();
    }
}
