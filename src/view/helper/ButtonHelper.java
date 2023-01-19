package view.helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;

public class ButtonHelper extends JButton {
    private int category;
    private int id;

    public ButtonHelper(int category, int id) {
        this.setText("Delete");
        this.category = category;
        this.id = id;
        this.setBounds(560, 20, 100, 40);
        this.setBackground(new Color(194, 24, 24));
        this.setForeground(new Color(250, 220, 220, 237));
        this.setFont(new Font(Font.SANS_SERIF, BOLD, 20));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

    public void addListener(ActionListener mal) {
        this.addActionListener(mal);
    }
}
