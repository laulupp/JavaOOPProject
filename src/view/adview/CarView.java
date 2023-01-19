package view.adview;

import model.entities.Car;
import view.helper.ButtonHelper;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;
import static java.awt.Font.SANS_SERIF;

public abstract class CarView {

    public static JPanel getCarPanel(Car car, boolean hasDelete, ButtonHelper button) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setPreferredSize(new Dimension(700, 300));
        if(hasDelete) {
            panel.add(button);
        }

        JLabel label = new JLabel(car.getTitle());
        label.setBounds(30,15,500,50);
        label.setFont(new Font(SANS_SERIF, BOLD, 24));
        label.setForeground(new Color(173, 220, 246));
        panel.add(label);

        JTextArea text = new JTextArea();
        text.setBorder(BorderFactory.createLineBorder(Color.black));
        text.setText("Car model : " + car.getModel() + "\n\nYear : " + car.getYear() + "\n\nEngine capacity (cm3): " + car.getEngineCapacity() +
                "\n\nPower (hp): " + car.getPower() + "\n\nPrice (€): " + car.getPrice() + "\nEstimated price (€): " + car.estimatePrice() +
                "\nEstimated price with discount (€)(owner should agree) : " + car.estimatePrice(10 )
                + "\n\nPollution factor : Euro " + car.getPollutionStandard() +  "\n\n" + car.getOwner() + "\n\nDescription : \n " + car.getDescription());
        text.setForeground(Color.BLACK);
        text.setFont(new Font(Font.SANS_SERIF, BOLD, 18));
        JScrollPane paneText = new JScrollPane(text);
        text.setEnabled(false);
        paneText.setBounds(25, 75, 650, 200);
        paneText.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.add(paneText);
        panel.setBackground(new Color(93, 118, 248));
        return panel;
    }
}
