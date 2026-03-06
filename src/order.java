import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class order extends JFrame
{
    private String username;
    private JLabel InsertUsername;
    private JButton logOutButton;
    private JPanel orderPanel;
    private JComboBox chooseCoffee;
    private JButton checkDetailsButton;
    private JButton makeOrderButton;
    private JButton checkOrdersButton;
    private JList ordersList;
    private JButton mainMenuButton;
    private Coffee[] arr;

    public order(String username)
    {
        this.username = username;
        InsertUsername.setText(username);

        this.arr = Admin.getCoffee();
        for (int i = 0; i < Admin.countCoffee(); i++)
            chooseCoffee.addItem(this.arr[i].getName());

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

        checkDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(checkDetailsButton, arr[chooseCoffee.getSelectedIndex()].printData());
            }
        });

        makeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Orders o = new Orders();
                o.addOrder(Admin.userIdByName(username), arr[chooseCoffee.getSelectedIndex()].getID());
                JOptionPane.showMessageDialog(makeOrderButton, "Order is made!");
            }
        });

        checkOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Orders o = new Orders();
                DatabaseElement[] arr = o.searchAfterID1(Admin.userIdByName(username));

                DefaultListModel<String> model = new DefaultListModel<>();
                for (int i = 0; i < arr.length; i++) model.addElement(arr[i].printData());

                ordersList.setModel(model);
            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu menu = new mainMenu(username);
                menu.setContentPane(menu.getMainMenuPanel());
                menu.setSize(1000,700);
                menu.setVisible(true);
                menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }

    public JPanel getOrderPanel()
    {
        return  orderPanel;
    }
}
