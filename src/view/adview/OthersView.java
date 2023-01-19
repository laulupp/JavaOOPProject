package view.adview;

import model.entities.Others;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;
import static java.awt.Font.SANS_SERIF;

public class OthersView {
    public static JPanel getOthersPanel(Others e, boolean hasDelete, JButton button){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setPreferredSize(new Dimension(700, 300));
        if(hasDelete){
            panel.add(button);
        }

        JLabel label = new JLabel(e.getTitle());
        label.setBounds(30,15,500,50);
        label.setFont(new Font(SANS_SERIF, BOLD, 24));
        label.setForeground(new Color(89, 89, 89));
        panel.add(label);

        JTextArea text = new JTextArea();
        text.setBorder(BorderFactory.createLineBorder(Color.black));
        text.setText("Category: " + e.getCategory() + "\n\nPrice (RON): " + e.getPrice() + "\n\nOwner : " + e.getOwner()
                + "\n\nDescription : \n" + e.getDescription());

        text.setForeground(Color.BLACK);
        text.setFont(new Font(Font.SANS_SERIF, BOLD, 18));
        JScrollPane paneText = new JScrollPane(text);
        text.setEnabled(false);
        paneText.setBounds(25, 75, 650, 200);
        paneText.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));


        panel.add(paneText);
        panel.setBackground(new Color(173, 173, 173));
        return panel;
    }
}
