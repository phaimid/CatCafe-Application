import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class details extends JFrame
{
    private String username;
    private JButton logOutButton;
    private JButton mainMenuButton;
    private JPanel detailsPanel;
    private JList list1;

    public details (String username)
    {
        this.username = username;

        User user = Admin.userByName(username);
        DefaultListModel<String> model = new DefaultListModel<>();

        model.addElement(user.printData());
        model.addElement("\n");
        model.addElement("Adopted cats: ");

        Adoptions a = new Adoptions();
        DatabaseElement[] arr = a.searchAfterID2(user.getID());
        for (DatabaseElement e : arr) model.addElement(e.printData());

        list1.setModel(model);

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

    public JPanel getDetailsPanel()
    {
        return detailsPanel;
    }
}
