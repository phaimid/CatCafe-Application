import java.sql.*;

public class Adoptions implements RelationalDatabase
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
                    = statement.executeQuery("SELECT count(*) FROM adoptions WHERE cat_id = " + id1); // The statement which will return the data we are looking for

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
                    = statement.executeQuery("select * from adoptions join users on user_id = users.id where cat_id = " + id1); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
                id2[i++] = new User(
                        resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("birth_date"), resultSet.getString("phone_number")
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
                    = statement.executeQuery("SELECT count(*) FROM adoptions WHERE user_id = " + id2); // The statement which will return the data we are looking for

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
                    = statement.executeQuery("select  * from adoptions join cats on cat_id = cats.id join cat_races on race_id = cat_races.id where user_id = " + id2); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
                id1[i++] = new Cat(
                        resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("race"), resultSet.getInt("isadopted") == 1
                );

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id1;
    }

    public void adopt(int cat_id, int user_id)
    {
        try {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator

            ResultSet resultSet
                    = statement.executeQuery("select * from cats where id = " + cat_id);
            resultSet.next();

            if (resultSet.getInt("isadopted") == 0) {
                statement.execute("insert into adoptions (cat_id, user_id) values (" + cat_id + ", " + user_id + ")"); // The statement which will update the data
                statement.execute("update cats set isadopted = 1 where id = " + cat_id); // Update the cat data such that we know it's adopted
                statement.execute("delete from cats_in_shelters where cat_id = " + cat_id);
                statement.execute("delete from cats_in_locations where cat_id = " + cat_id);
            } else
            {
                System.out.println("Cat already adopted!");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
