import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;

public class Main
{
    public void main(String[] args)
    {
        logInScreen logIn = new logInScreen();
        logIn.setContentPane(logIn.getLogInPanel());
        logIn.setSize(500, 500);
        logIn.setVisible(true);
        logIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
