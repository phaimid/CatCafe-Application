import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu extends JFrame {
    private String username;
    private JPanel mainMenuPanel;
    private JLabel InsertUsername;
    private JButton orderButton;
    private JButton logOutButton;
    private JButton makeReservationButton;
    private JButton adoptCatButton;
    private JButton checkMenuButton;
    private JButton accountDetailsButton;

    public mainMenu(String username)
    {
        this.username = username;
        InsertUsername.setText(username);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logInScreen logIn = new logInScreen();
                logIn.setContentPane(logIn.getLogInPanel());
                logIn.setSize(500, 500);
                logIn.setVisible(true);
                logIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order order = new order(username);
                order.setContentPane(order.getOrderPanel());
                order.setSize(1000,500);
                order.setVisible(true);
                order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
        makeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservation reservation = new reservation(username);
                reservation.setContentPane(reservation.getReservationPanel());
                reservation.setSize(1000, 800);
                reservation.setVisible(true);
                reservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });

        checkMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSearcher menu = new menuSearcher(username);
                menu.setContentPane(menu.getMenuPanel());
                menu.setSize(1000, 500);
                menu.setVisible(true);
                menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
        adoptCatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adopt adopt = new adopt(username);
                adopt.setContentPane(adopt.getAdoptPanel());
                adopt.setSize(1000, 500);
                adopt.setVisible(true);
                adopt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
        accountDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                details details = new details(username);
                details.setContentPane(details.getDetailsPanel());
                details.setSize(1000, 500);
                details.setVisible(true);
                details.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }

    public JPanel getMainMenuPanel()
    {
        return mainMenuPanel;
    }
}
