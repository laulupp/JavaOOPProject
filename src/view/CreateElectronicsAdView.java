package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;
import static java.awt.Font.SANS_SERIF;

public class CreateElectronicsAdView extends JFrame implements CreateAd {
    private JPanel panel = new JPanel();
    private JButton back;
    private JTextArea description;
    private JTextField title;
    private JTextField price;
    private JTextField eConsumption;
    private JButton submit;
    private JLabel error;
    private JButton alertBtn = new JButton("Back");
    private JFrame alert;
    private final int pHeight = 600;
    private final int pWidth = 800;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final int x = (screenSize.width - pWidth) / 2;
    final int y = (screenSize.height - pHeight) / 2;
    private void addComponents() {
        JLabel pageTitle = new JLabel();
        pageTitle.setBounds(40, 20, 450, 50);
        pageTitle.setFont(new Font(Font.SANS_SERIF, BOLD, 35));
        pageTitle.setText("Create an electronics AD");
        panel.add(pageTitle);

        back = new JButton("Back");
        back.setBounds(630, 20, 100, 50);
        back.setFont(new Font(Font.SANS_SERIF, BOLD, 22));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(back);

        JLabel titleLabel = new JLabel("Title : ");
        titleLabel.setBounds(40, 130, 150, 40);
        titleLabel.setFont(new Font(Font.SANS_SERIF, BOLD, 24));
        title = new JTextField();
        title.setBounds(310, 130, 150, 40);
        title.setFont(new Font(Font.SANS_SERIF, 0, 24));
        panel.add(titleLabel);
        panel.add(title);

        JLabel priceLabel = new JLabel("Price : ");
        priceLabel.setBounds(40, 205, 150, 40);
        priceLabel.setFont(new Font(Font.SANS_SERIF, BOLD, 24));
        price = new JTextField();
        price.setBounds(310, 205, 150, 40);
        price.setFont(new Font(Font.SANS_SERIF, 0, 24));
        panel.add(priceLabel);
        panel.add(price);

        JLabel eConsumptionLabel = new JLabel("Energy consumption : ");
        eConsumptionLabel.setBounds(40, 280, 280, 40);
        eConsumptionLabel.setFont(new Font(Font.SANS_SERIF, BOLD, 24));
        eConsumption = new JTextField();
        eConsumption.setBounds(310, 280, 150, 40);
        eConsumption.setFont(new Font(Font.SANS_SERIF, 0, 24));
        panel.add(eConsumptionLabel);
        panel.add(eConsumption);

        JLabel descriptionLabel = new JLabel("Description : ");
        descriptionLabel.setBounds(40, 340, 180, 100);
        descriptionLabel.setFont(new Font(Font.SANS_SERIF, BOLD, 24));
        JLabel descriptionLabel2 = new JLabel("Should contain contact details!");
        descriptionLabel2.setBounds(15, 360, 230, 100);
        descriptionLabel2.setFont(new Font(Font.SANS_SERIF, 0, 14));

        description = new JTextArea();
        //description.setBounds(220, 440, 300, 100);
        description.setFont(new Font(Font.SANS_SERIF, 0, 24));
        JScrollPane descriptionPane = new JScrollPane(description);
        descriptionPane.setBounds(220, 350, 350, 120);
        panel.add(descriptionLabel);
        panel.add(descriptionLabel2);
        panel.add(descriptionPane);

        submit = new JButton("Create ad");
        submit.setBounds(600, 480, 160, 60);
        submit.setFont(new Font(Font.SANS_SERIF, BOLD, 22));
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(submit);

        error = new JLabel("");
        error.setBounds(0, 480, 600, 50);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setForeground(new Color(203, 41, 41));
        error.setFont(new Font(Font.SANS_SERIF, BOLD, 22));
        panel.add(error);
    }
    public CreateElectronicsAdView() {
        panel.setLayout(null);
        panel.setBackground(new Color(180, 180, 180));
        addComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setSize(new Dimension(pWidth, pHeight));
        this.setResizable(false);
        this.setLocation(x, y);
    }
    public void addedSuccessfully() {
        this.setEnabled(false);
        int posX = (screenSize.width - 300) / 2;
        int posY = (screenSize.height - 220) / 2;
        alert = new JFrame("Successful action");
        alert.setDefaultCloseOperation(EXIT_ON_CLOSE);
        alert.setSize(300, 220);
        alert.setLocation(posX, posY);

        alert.setLayout(null);

        JLabel lbl = new JLabel("The AD was placed.");
        lbl.setBounds(0, 30, 300, 50);
        lbl.setHorizontalAlignment(0);
        lbl.setFont(new Font(SANS_SERIF, BOLD, 18));
        alert.add(lbl);

        alertBtn.setBounds(100, 100, 100, 50);
        alertBtn.setFont(new Font(SANS_SERIF, BOLD, 16));
        alertBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        alert.add(alertBtn);

        alert.setVisible(true);
    }
    public JFrame getAlert(){
        return alert;
    }
    public void setError(String e){
        error.setText(e);
    }
    public void addAlertListener(ActionListener mal) {
        alertBtn.addActionListener(mal);
    }
    public void addBackListener(ActionListener mal) {
        back.addActionListener(mal);
    }

    public void addSubmitListener(ActionListener mal) {
        submit.addActionListener(mal);
    }

    public String getDescription() {
        return description.getText();
    }

    public String getTitle() {
        return title.getText();
    }
    public String getEnergyConsumption(){
        return eConsumption.getText();
    }
    public String getPrice(){
        return price.getText();
    }
}
