import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reservation extends JFrame {
    private String username;
    private JPanel reservationPanel;
    private JButton logOutButton;
    private JLabel insertUsername;
    private JComboBox chooseLocation;
    private JButton makeReservationButton;
    private JComboBox chooseDate;
    private JComboBox chooseMonth;
    private JComboBox chooseYear;
    private JButton checkMadeReservationsButton;
    private JList list1;
    private JButton backToMainMenuButton;
    private JComboBox chooseHour;
    private JComboBox chooseMinute;
    private JButton checkAvailableSeatsButton;
    private JComboBox chooseSeats;
    private JButton deleteReservationButton;
    private JButton checkLocalCats3Button;
    private JList list2;

    public reservation(String username)
    {
        this.username = username;
        insertUsername.setText(username);

        Locations[] arr = Admin.getLocations();
        for (int i = 0; i < arr.length; i++)
            chooseLocation.addItem(arr[i].getName());

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
        checkAvailableSeatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day = Integer.parseInt(chooseDate.getSelectedItem().toString());
                int month = Integer.parseInt(chooseMonth.getSelectedItem().toString());
                int year = Integer.parseInt(chooseYear.getSelectedItem().toString());
                int hour = Integer.parseInt(chooseHour.getSelectedItem().toString());
                int minute = Integer.parseInt(chooseMinute.getSelectedItem().toString());
                String date = year + "/" + month + "/" + day;
                String address = chooseLocation.getSelectedItem().toString();

                JOptionPane.showMessageDialog(checkAvailableSeatsButton, Locations.checkSeats(address, date, hour, minute));
            }
        });
        makeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day = Integer.parseInt(chooseDate.getSelectedItem().toString());
                int month = Integer.parseInt(chooseMonth.getSelectedItem().toString());
                int year = Integer.parseInt(chooseYear.getSelectedItem().toString());
                int hour = Integer.parseInt(chooseHour.getSelectedItem().toString());
                int minute = Integer.parseInt(chooseMinute.getSelectedItem().toString());
                int seats = Integer.parseInt(chooseSeats.getSelectedItem().toString());

                String address = chooseLocation.getSelectedItem().toString();
                String date = chooseYear.getSelectedItem().toString() + "/" + chooseMonth.getSelectedItem().toString() + "/" + chooseDate.getSelectedItem().toString();
                String clock = chooseHour.getSelectedItem().toString() + ":" + chooseMinute.getSelectedItem().toString();

                if (!Admin.checkReservationDate(day, month, year, hour, minute) || !Admin.checkDate(day, month, year)) JOptionPane.showMessageDialog(makeReservationButton, "Invalid date!");
                else if (seats > Locations.checkSeats(address, date, hour, minute)) JOptionPane.showMessageDialog(makeReservationButton, "Not enough seats!");
                else
                {
                    Reservations r = new Reservations();
                    r.addReservation(Admin.userIdByName(username), chooseLocation.getSelectedIndex() + 1, date, clock, seats);
                    JOptionPane.showMessageDialog(makeReservationButton, "Reservation made!");
                }
            }
        });

        backToMainMenuButton.addActionListener(new ActionListener() {
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

        checkMadeReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reservations r = new Reservations();
                String[] arr = r.checkReservations(Admin.userIdByName(username));

                DefaultListModel<String> model = new DefaultListModel<>();
                for (int i = 0; i < arr.length; i++) model.addElement(arr[i]);

                list1.setModel(model);
            }
        });

        deleteReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String reservationData = list1.getSelectedValue().toString();
                    String[] reservationDataSplit = reservationData.split("[ ,:]");

                    int reservation_id = Integer.parseInt(reservationDataSplit[2]);

                    Reservations r = new Reservations();

                    r.deleteReservation(reservation_id);

                    String[] arr = r.checkReservations(Admin.userIdByName(username));

                    DefaultListModel<String> model = new DefaultListModel<>();
                    for (int i = 0; i < arr.length; i++) model.addElement(arr[i]);

                    list1.setModel(model);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(deleteReservationButton, "No Reservation Selected!");
                }
            }
        });

        checkLocalCats3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CatsLocations cl = new CatsLocations();
                DatabaseElement[] arr = cl.searchAfterID2(chooseLocation.getSelectedIndex() + 1);

                DefaultListModel<String> model = new DefaultListModel<>();
                for (int i = 0; i < arr.length; i++) model.addElement(arr[i].printData());

                list2.setModel(model);
            }
        });
    }

    public JPanel getReservationPanel()
    {
        return reservationPanel;
    }
}
