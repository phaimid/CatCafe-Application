import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adopt extends JFrame {
    private String username;
    private JPanel adoptPanel;
    private JButton logOutButton;
    private JLabel insertName;
    private JButton mainMenuButton;
    private JComboBox shelterBox;
    private JList catList;
    private JButton catDetailsButton;
    private JButton adoptButton;

    public adopt(String username) {
        this.username = username;
        insertName.setText(username);

        Shelters[] shelters = Admin.getShelters();
        for (int i = 0; i < shelters.length; i++) shelterBox.addItem(shelters[i].getName());

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

        shelterBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CatsShelters cs = new CatsShelters();
                DatabaseElement[] cats = cs.searchAfterID2(shelterBox.getSelectedIndex() + 1);

                DefaultListModel<String> model = new DefaultListModel<>();
                for (DatabaseElement c : cats) model.addElement(c.getName());

                catList.setModel(model);
            }
        });

        catDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String name = catList.getSelectedValue().toString();
                    JOptionPane.showMessageDialog(catDetailsButton, Admin.catByName(name).printData());
                } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(catDetailsButton, "No Cat Selected!");
                }
            }
        });
        adoptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String name = catList.getSelectedValue().toString();
                    int id = Admin.catIdByName(name);

                    Adoptions adoptions = new Adoptions();

                    adoptions.adopt(id, Admin.userIdByName(username));

                    CatsShelters cs = new CatsShelters();
                    DatabaseElement[] cats = cs.searchAfterID2(shelterBox.getSelectedIndex() + 1);

                    DefaultListModel<String> model = new DefaultListModel<>();
                    for (DatabaseElement c : cats) model.addElement(c.getName());

                    catList.setModel(model);

                    JOptionPane.showMessageDialog(adoptButton, "Cat Adopted :3");
                } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(adoptButton, "No Cat Selected!");
                }
            }
        });
    }

    public JPanel getAdoptPanel()
    {
        return  adoptPanel;
    }
}
