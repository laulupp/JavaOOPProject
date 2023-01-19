package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SelectAdTypeView extends JFrame {
    private JPanel panel = new JPanel();
    private JButton create;
    private JButton back;
    private JComboBox comboBox;
    private final int pHeight = 300;
    private final int pWidth = 300;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final int x = (screenSize.width - pWidth) / 2;
    final int y = (screenSize.height - pHeight) / 2;

    private void addComponents() {
        JLabel label = new JLabel("Select a category :");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        label.setBounds(0, 20, pWidth, 50);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        String[] elements = {"Cars", "Electronics", "Others"};
        comboBox = new JComboBox(elements);
        comboBox.setBounds(50, 90, 200, 40);
        comboBox.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(comboBox);

        back = new JButton("Back");
        back.setBounds(35, 170, 100, 50);
        back.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(back);

        create = new JButton("Create");
        create.setBounds(165, 170, 100, 50);
        create.setBackground(new Color(47, 171, 1));
        create.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        create.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(create);
    }
    public int getAdType(){
        return comboBox.getSelectedIndex();
    }

    public SelectAdTypeView() {
        panel.setLayout(null);
        panel.setBackground(new Color(180, 180, 180));
        addComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setSize(new Dimension(pWidth, pHeight));
        this.setResizable(false);
        this.setLocation(x, y);
    }
    public void addCreateListener(ActionListener mal){
        create.addActionListener(mal);
    }
    public void addBackListener(ActionListener mal){
        back.addActionListener(mal);
    }
}
