import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logInScreen extends JFrame {
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton registerButton;
    private JButton logInButton;
    private JPanel logInPanel;

    public logInScreen() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Admin.validateAccount(usernameInput.getText(), passwordInput.getText()))
                {
                    mainMenu menu = new mainMenu(usernameInput.getText());
                    menu.setContentPane(menu.getMainMenuPanel());
                    menu.setSize(1000,700);
                    menu.setVisible(true);
                    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }
                else JOptionPane.showMessageDialog(logInButton, "Invalid Account!");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerScreen register = new registerScreen();
                register.setContentPane(register.getRegisterPanel());
                register.setSize(1000, 700);
                register.setVisible(true);
                register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        });
    }

    public JPanel getLogInPanel()
    {
        return logInPanel;
    }
}
