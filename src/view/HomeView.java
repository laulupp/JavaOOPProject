package view;

import model.entities.Car;
import model.entities.Electronics;
import model.entities.Others;
import model.entities.User;
import view.adview.CarView;
import view.adview.ElectronicsView;
import view.adview.OthersView;
import view.helper.ButtonHelper;
import view.helper.PanelHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Font.BOLD;

public class HomeView extends JFrame {
    private JLabel title;
    private JLabel title2;
    private JPanel homePanel = new JPanel();
    private JPanel centralPanel = new JPanel();
    private JButton placeAd;
    private JButton logout;
    private ArrayList<ButtonHelper> electronicsBtns = new ArrayList<ButtonHelper>();
    private ArrayList<PanelHelper> electronicsPanels = new ArrayList<PanelHelper>();
    private ArrayList<ButtonHelper> carBtns = new ArrayList<ButtonHelper>();
    private ArrayList<PanelHelper> carPanels = new ArrayList<PanelHelper>();
    private ArrayList<ButtonHelper> othersBtns = new ArrayList<ButtonHelper>();
    private ArrayList<PanelHelper> othersPanels = new ArrayList<PanelHelper>();

    private final int pHeight = 600;
    private final int pWidth = 800;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final int x = (screenSize.width - pWidth) / 2;
    final int y = (screenSize.height - pHeight) / 2;
    private void addComponents(){
        centralPanel = new JPanel();

        centralPanel.setLayout(new GridLayout(0, 1, 10, 10));
        centralPanel.setBackground(new Color(140,140,140));
        JScrollPane scrollPane = new JScrollPane(centralPanel);
        scrollPane.setBounds(30,130,pWidth - 80,pHeight - 200);
        homePanel.add(scrollPane);

        title = new JLabel("Welcome,");
        title.setFont(new Font(Font.SANS_SERIF, BOLD, 28));
        title.setBounds(30,20,200,50);
        homePanel.add(title);

        title2 = new JLabel(User.getUsername() + " !");
        title2.setFont(new Font(Font.SANS_SERIF, BOLD, 28));
        title2.setBounds(40,70,200,50);
        homePanel.add(title2);

        placeAd = new JButton("Place an advertisment");
        placeAd.setFont(new Font(Font.SANS_SERIF, BOLD, 18));
        placeAd.setBounds(250,20,300,50);
        placeAd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        homePanel.add(placeAd);

        logout = new JButton("Logout");
        logout.setFont(new Font(Font.SANS_SERIF, BOLD, 18));
        logout.setBounds(650,20,100,50);
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setBackground(new Color(201, 55, 55));
        homePanel.add(logout);
    }
    public HomeView() {
        homePanel.setLayout(null);
        homePanel.setBackground(new Color(180,180,180));

        addComponents();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(homePanel);
        this.setSize(new Dimension(pWidth, pHeight));
        this.setResizable(false);
        this.setLocation(x, y);

    }
    public void addCarToPanel(Car car, boolean hasDelete){
        ButtonHelper btn = new ButtonHelper(0, car.getId());
        JPanel carP = CarView.getCarPanel(car, hasDelete, btn);
        carBtns.add(btn);
        carPanels.add(new PanelHelper(carP, 0, car.getId()));
        centralPanel.add(carP);
    }

    public int getButtonId(Object o){
        ButtonHelper b = (ButtonHelper)(o);
        return b.getId();
    }
    public int getButtonCategory(Object o){
        ButtonHelper b = (ButtonHelper)(o);
        return b.getCategory();
    }

    public void addElectronicsToPanel(Electronics e, boolean hasDelete){
        ButtonHelper btn = new ButtonHelper(1, e.getId());
        JPanel electronicsP = ElectronicsView.getElectronicsPanel(e, hasDelete, btn);
        electronicsBtns.add(btn);
        electronicsPanels.add(new PanelHelper(electronicsP, 1, e.getId()));
        centralPanel.add(electronicsP);
    }
    public void deleteElectronicsFromPanel(int id){
        for(PanelHelper e : electronicsPanels){
            if(e.getId() == id){
                centralPanel.remove(e.getPanel());
                centralPanel.revalidate();
                centralPanel.repaint();
                JOptionPane.showMessageDialog(this, "The AD was deleted successfully!", "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public void deleteCarFromPanel(int id){
        for(PanelHelper c : carPanels){
            if(c.getId() == id){
                centralPanel.remove(c.getPanel());
                centralPanel.revalidate();
                centralPanel.repaint();
                JOptionPane.showMessageDialog(this, "The AD was deleted successfully!", "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public void deleteOthersFromPanel(int id){
        for(PanelHelper c : othersPanels){
            if(c.getId() == id){
                centralPanel.remove(c.getPanel());
                centralPanel.revalidate();
                centralPanel.repaint();
                JOptionPane.showMessageDialog(this, "The AD was deleted successfully!", "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public void addOthersToPanel(Others o, boolean hasDelete){
        ButtonHelper btn = new ButtonHelper(2, o.getId());
        JPanel othersP = OthersView.getOthersPanel(o, hasDelete, btn);
        othersBtns.add(btn);
        othersPanels.add(new PanelHelper(othersP, 2, o.getId()));
        centralPanel.add(othersP);
    }
    public void addPlaceAdListener(ActionListener mal){
        placeAd.addActionListener(mal);
    }
    public void addLogoutListener(ActionListener mal){
        logout.addActionListener(mal);
    }
    public void addDeleteListener(ActionListener mal){
        for(ButtonHelper b : electronicsBtns){
            b.addListener(mal);
        }
        for(ButtonHelper b : carBtns){
            b.addListener(mal);
        }
        for(ButtonHelper b : othersBtns){
            b.addListener(mal);
        }
    }

    public void setAdminInterface() {
        title.setText("ADMIN");
        title.setForeground(new Color(180, 0, 0));
        //title2.setForeground(new Color(180, 0, 0));
        title2.setVisible(false);
        placeAd.setVisible(false);
        this.setBackground(new Color(255, 176, 176));
    }
}
