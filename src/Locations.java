import java.sql.*;

public class Locations extends DatabaseElement
{
    private int seats;

    public Locations(int id, String name, int seats)
    {
        super(id, name);
        this.seats = seats;
    }

    public int getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getSeats() { return seats; }

    public String printData()
    {
        return "Address: " + name + ", Seats: " + seats;
    }

    public static int checkSeats(String location, String date, int hour, int minute)
    {
        int Seats = 0;
        try {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from locations where address = '" + location + "'"); // The statement which will return the data we are looking for

            // Check the values
            resultSet.next();
            Seats = resultSet.getInt("seats");

            connection.close(); // Close connections
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from reservations join locations on location_id = locations.id where address = '" + location + "' and date = '" + date + "'"); // The statement which will return the data we are looking for

            // Check the values
            while (resultSet.next())
            {
                String time = resultSet.getString("time");
                String[] timeSplit = time.split("[:]");
                int restime = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
                int curtime = hour * 60 + minute;
                if (curtime - restime <= 60 && curtime - restime >= 0)
                    Seats -= resultSet.getInt("reserved_seats");
            }


            connection.close(); // Close connections
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Seats;
    }
}
