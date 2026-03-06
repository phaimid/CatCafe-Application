import java.sql.*;

public class Reservations implements RelationalDatabase
{
    public DatabaseElement[] searchAfterID1(int id1)
    {
        int count = 0;

        try {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("SELECT count(*) FROM reservations WHERE user_id = " + id1); // The statement which will return the data we are looking for

            // Set the received data
            resultSet.next();

            count = resultSet.getInt("count");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DatabaseElement[] id2 = new DatabaseElement[count];

        try {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from reservations join locations on location_id = locations.id where user_id = " + id1); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
                id2[i++] = new Locations(
                        resultSet.getInt("location_id"), resultSet.getString("address"), resultSet.getInt("seats")
                );


            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id2;
    }

    public DatabaseElement[] searchAfterID2(int id2)
    {
        int count = 0;

        try {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("SELECT count(*) FROM reservations WHERE location_id = " + id2); // The statement which will return the data we are looking for

            // Set the received data
            resultSet.next();

            count = resultSet.getInt("count");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DatabaseElement[] id1 = new DatabaseElement[count];

        try {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select  * from reservations join users on user_id = users.id where location_id = " + id2); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
                id1[i++] = new User(
                        resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("birth_date"), resultSet.getString("phone_number")
                );

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id1;
    }

    public void addReservation(int user_id, int location_id, String date, String time, int seats)
    {
        try {
            // Add data given as parameters
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator

            statement.execute("insert into reservations (user_id, location_id, date, time, reserved_seats) values (" + user_id + ", " + location_id + ", '" + date + "', '" + time + "', " + seats + ")"); // The statement which will return the data we are looking for

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] checkReservations(int user_id)
    {
        int count = 0;

        try {
            // Select the elements based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("SELECT count(*) FROM reservations WHERE user_id = " + user_id); // The statement which will return the data we are looking for

            if (resultSet.next())
                count = resultSet.getInt("count");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] out = new String[count];

        try {
            // Select the elements based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("SELECT * FROM reservations WHERE user_id = " + user_id); // The statement which will return the data we are looking for

            // Check data
            Locations[] arr = Admin.getLocations();

            int i = 0;
            while (resultSet.next())
                    out[i++] = "Id: " + resultSet.getInt("id") +
                            ", Location: " + arr[resultSet.getInt("location_id") - 1].getName() + ", Date: " + resultSet.getString("date") + ", Time: " + resultSet.getString("time") + ", Seats: " + resultSet.getInt("reserved_seats");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out;
    }

    public void deleteReservation(int reservation_id)
    {
        try {
            // Add data given as parameters
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator

            statement.execute("delete from reservations where id = " + reservation_id); // The statement which will return the data we are looking for

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
