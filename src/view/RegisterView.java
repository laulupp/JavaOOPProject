package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import static java.awt.Font.*;

public class RegisterView extends JFrame {
    private JPanel registerPanel = new JPanel();
    private JLabel title = new JLabel("Register", SwingConstants.CENTER);
    private JLabel labelUsername = new JLabel("Username :", SwingConstants.LEFT);
    private JLabel labelPassword = new JLabel("Password :", SwingConstants.LEFT);
    private JLabel labelRePassword = new JLabel("Repeat password :", SwingConstants.LEFT);
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JPasswordField rePassword = new JPasswordField();
    private JLabel error = new JLabel("", SwingConstants.CENTER);
    private JButton button = new JButton("Register");
    private JLabel sendLogin = new JLabel("Click here to login", SwingConstants.CENTER);

    private final int pHeight = 600;
    private final int pWidth = 800;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final int x = (screenSize.width - pWidth) / 2;
    final int y = (screenSize.height - pHeight) / 2;

    private void addComponents(){
        title.setBounds((pWidth - 300)/2, 30, 300, 50);
        title.setFont(new Font(SANS_SERIF, BOLD, 36));

        labelUsername.setBounds((pWidth - 300)/2, 100, 300, 50);
        labelUsername.setFont(new Font(SANS_SERIF, BOLD, 24));
        username.setBounds((pWidth - 300)/2, 150, 300, 40);
        username.setFont(new Font(SANS_SERIF, BOLD, 20));

        labelPassword.setBounds((pWidth - 300)/2, 190, 300, 50);
        labelPassword.setFont(new Font(SANS_SERIF, BOLD, 24));
        password.setBounds((pWidth - 300)/2, 240, 300, 40);
        password.setFont(new Font(SANS_SERIF, BOLD, 20));

        labelRePassword.setBounds((pWidth - 300)/2, 280, 300, 50);
        labelRePassword.setFont(new Font(SANS_SERIF, BOLD, 24));
        rePassword.setBounds((pWidth - 300)/2, 330, 300, 40);
        rePassword.setFont(new Font(SANS_SERIF, BOLD, 20));

        error.setBounds((pWidth - 380)/2, 380, 380, 50);
        error.setFont(new Font(SANS_SERIF, BOLD, 20));
        error.setForeground(new Color(200, 0, 0));

        button.setBounds((pWidth - 150)/2, 440, 150, 50);
        button.setFont(new Font(SANS_SERIF, BOLD, 24));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        sendLogin.setBounds((pWidth - 300)/2, 490, 300, 50);
        sendLogin.setFont(new Font(SANS_SERIF, BOLD, 16));
        sendLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sendLogin.setForeground(new Color(100, 100, 100));

        registerPanel.add(title);
        registerPanel.add(labelUsername);
        registerPanel.add(username);
        registerPanel.add(labelPassword);
        registerPanel.add(password);
        registerPanel.add(labelRePassword);
        registerPanel.add(rePassword);
        registerPanel.add(error);
        registerPanel.add(button);
        registerPanel.add(sendLogin);
    }
    public RegisterView(){
        registerPanel.setLayout(null);
        registerPanel.setBackground(new Color(180,180,180));
        addComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(registerPanel);
        this.setSize(new Dimension(pWidth, pHeight));
        this.setResizable(false);
        this.setLocation(x, y);
    }

    public String getUsername(){
        return username.getText();
    }
    public String getPassword(){
        return String.valueOf(password.getPassword());
    }
    public String getRePassword(){
        return String.valueOf(rePassword.getPassword());
    }
    public void setError(String error){
        this.error.setText(error);
    }
    public void setSendLoginColor(Color c){
        sendLogin.setForeground(c);
    }
    public void addRegisterListener(ActionListener mal){
        button.addActionListener(mal);
    }
    public void addSendLoginListener(MouseListener mal){
        sendLogin.addMouseListener(mal);
    }
}