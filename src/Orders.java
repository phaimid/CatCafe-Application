import java.sql.*;

public class Orders implements RelationalDatabase
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
                    = statement.executeQuery("SELECT count(*) FROM orders WHERE user_id = " + id1); // The statement which will return the data we are looking for

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
                    = statement.executeQuery("select * from orders join coffee on coffee_id = coffee.id join coffee_types on type_id = coffee_types.id join providers on provider_id = providers.id where user_id = " + id1); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
                id2[i++] = new Coffee(
                        resultSet.getInt("coffee_id"), resultSet.getString("name"), resultSet.getInt("intensity"),
                        resultSet.getFloat("weight"), resultSet.getString("type"), resultSet.getString("provider")
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
                    = statement.executeQuery("SELECT count(*) FROM orders WHERE coffee_id = " + id2); // The statement which will return the data we are looking for

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
                    = statement.executeQuery("select * from orders join users on user_id = users.id where coffee_id = " + id2); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
                id1[i++] = new User(
                    resultSet.getInt("user_id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"),
                    resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("birth_date"), resultSet.getString("phone_number")
            );

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id1;
    }

    public void addOrder(int user_id, int coffee_id)
    {
        try {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator

            statement.execute("insert into orders (user_id, coffee_id) values (" + user_id + ", " + coffee_id + ")"); // The statement which will return the data we are looking for

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
