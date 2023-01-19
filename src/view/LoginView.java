package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import static java.awt.Font.*;

public class LoginView extends JFrame {
    private JPanel loginPanel = new JPanel();
    private JLabel title = new JLabel("Login", SwingConstants.CENTER);
    private JLabel labelUsername = new JLabel("Username :", SwingConstants.LEFT);
    private JLabel labelPassword = new JLabel("Password :", SwingConstants.LEFT);
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JLabel error = new JLabel("", SwingConstants.CENTER);
    private JButton button = new JButton("Login");
    private JLabel sendRegister = new JLabel("Click here to create an account", SwingConstants.CENTER);

    private final int pHeight = 600;
    private final int pWidth = 800;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final int x = (screenSize.width - pWidth) / 2;
    final int y = (screenSize.height - pHeight) / 2;

    private void addComponents(){
        title.setBounds((pWidth - 300)/2, 50, 300, 50);
        title.setFont(new Font(SANS_SERIF, BOLD, 36));

        labelUsername.setBounds((pWidth - 300)/2, 150, 300, 50);
        labelUsername.setFont(new Font(SANS_SERIF, BOLD, 24));
        username.setBounds((pWidth - 300)/2, 200, 300, 40);
        username.setFont(new Font(SANS_SERIF, BOLD, 20));

        labelPassword.setBounds((pWidth - 300)/2, 260, 300, 50);
        labelPassword.setFont(new Font(SANS_SERIF, BOLD, 24));
        password.setBounds((pWidth - 300)/2, 310, 300, 40);
        password.setFont(new Font(SANS_SERIF, BOLD, 20));

        error.setBounds((pWidth - 300)/2, 360, 300, 50);
        error.setFont(new Font(SANS_SERIF, BOLD, 20));
        error.setForeground(new Color(200, 0, 0));

        button.setBounds((pWidth - 150)/2, 420, 150, 50);
        button.setFont(new Font(SANS_SERIF, BOLD, 24));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        sendRegister.setBounds((pWidth - 300)/2, 480, 300, 50);
        sendRegister.setFont(new Font(SANS_SERIF, BOLD, 16));
        sendRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sendRegister.setForeground(new Color(100, 100, 100));

        loginPanel.add(title);
        loginPanel.add(labelUsername);
        loginPanel.add(username);
        loginPanel.add(labelPassword);
        loginPanel.add(password);
        loginPanel.add(error);
        loginPanel.add(button);
        loginPanel.add(sendRegister);
    }
    public LoginView(){
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(180,180,180));
        addComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginPanel);
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
    public void setError(String error){
        this.error.setText(error);
    }
    public void setSendRegisterColor(Color c){
        sendRegister.setForeground(c);
    }
    public void addLoginListener(ActionListener mal){
        button.addActionListener(mal);
    }
    public void addSendRegisterListener(MouseListener mal){
        sendRegister.addMouseListener(mal);
    }
}
/*

 */