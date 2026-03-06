import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerScreen extends JFrame {
    private JLabel Register;
    private JPanel registerPanel;
    private JTextField usernameInput;
    private JTextField emailInput;
    private JTextField passwordInput;
    private JTextField firstNameInput;
    private JTextField lastNameInput;
    private JComboBox dayInput;
    private JComboBox monthInput;
    private JComboBox yearInput;
    private JTextField phoneNumberInput;
    private JButton registerButton;
    private JButton backToLogInButton;

    public registerScreen() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameInput.getText();
                String email = emailInput.getText();
                String password = passwordInput.getText();
                String first_name = firstNameInput.getText();
                String last_name = lastNameInput.getText();
                String birth_date = monthInput.getSelectedItem().toString() + "/" + dayInput.getSelectedItem().toString() + "/" + yearInput.getSelectedItem().toString();
                String phone_number = phoneNumberInput.getText();

                if (!Admin.checkEmail(email)) JOptionPane.showMessageDialog(registerButton, "Invalid email!");
                else if (!Admin.checkPhoneNumber(phone_number)) JOptionPane.showMessageDialog(registerButton, "Invalid phone number!");
                else if (!Admin.checkDate(Integer.parseInt(dayInput.getSelectedItem().toString()), Integer.parseInt(monthInput.getSelectedItem().toString()), Integer.parseInt(yearInput.getSelectedItem().toString()))) JOptionPane.showMessageDialog(registerButton, "Invalid date!");
                else if (Admin.userIdByName(username) != -1) JOptionPane.showMessageDialog(registerButton, "Account with same username already exists!");
                else if (Admin.userIdByEmail(email) != -1) JOptionPane.showMessageDialog(registerButton, "Email already linked to another account!");
                else if (Admin.userIdByPhone(phone_number) != -1) JOptionPane.showMessageDialog(registerButton, "Phone number already linked to another account!");
                else
                {
                    Admin.registerUser(username, email, password, first_name, last_name, birth_date, phone_number);
                    logInScreen logIn = new logInScreen();
                    logIn.setContentPane(logIn.getLogInPanel());
                    logIn.setSize(500, 500);
                    logIn.setVisible(true);
                    logIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }
            }
        });
        backToLogInButton.addActionListener(new ActionListener() {
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
    }

    public JPanel getRegisterPanel()
    {
        return registerPanel;
    }
}
