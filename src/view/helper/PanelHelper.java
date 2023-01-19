package view.helper;

import javax.swing.*;

public class PanelHelper {
    private JPanel panel;
    private int category;
    private int id;
    public PanelHelper(JPanel panel, int category, int id){
        this.panel = panel;
        this.category = category;
        this.id = id;
    }

    public JPanel getPanel() {
        return panel;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
