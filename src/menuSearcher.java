import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuSearcher extends JFrame
{
    private String username;
    private JPanel menuPanel;
    private JLabel InputUsername;
    private JButton logOutButton;
    private JComboBox chooseLocation;
    private JButton checkMenuButton;
    private JScrollPane menuPane;
    private JButton mainMenuButton;
    private Locations[] arr;

    public menuSearcher(String username) {

        this.username = username;
        InputUsername.setText(username);

        this.arr = Admin.getLocations();
        for (int i = 0; i < arr.length; i++)
            chooseLocation.addItem(this.arr[i].getName());

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
        checkMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocationsTypes lt = new LocationsTypes();
                DatabaseElement[] arr = lt.searchAfterID1(chooseLocation.getSelectedIndex() + 1);

                DefaultListModel<String> model = new DefaultListModel<>();
                for (int i = 0; i < arr.length; i++) model.addElement(arr[i].printData());

                JList<String> list1 = new JList<>(model);
                list1.setCellRenderer(new ListCellRenderer<String>() {
                    @Override
                    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
                        JTextArea textArea = new JTextArea(value);
                        textArea.setLineWrap(true);
                        textArea.setWrapStyleWord(true);
                        textArea.setOpaque(true);
                        textArea.setFont(list.getFont());

                        if (isSelected) {
                            textArea.setBackground(list.getSelectionBackground());
                            textArea.setForeground(list.getSelectionForeground());
                        } else {
                            textArea.setBackground(list.getBackground());
                            textArea.setForeground(list.getForeground());
                        }

                        textArea.setSize(list.getWidth(), Short.MAX_VALUE);

                        return textArea;
                    }
                });
                menuPane.setViewportView(list1);
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

    public JPanel getMenuPanel()
    {
        return menuPanel;
    }
}
