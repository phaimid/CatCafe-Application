import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FoodType extends DatabaseElement
{
    public FoodType(int id, String name)
    {
        super(id, name);
    }

    public int getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String printData()
    {
        String output = "Food Type: " + name + "\n";

        String[] arr = this.getMenu();
        for (String s : arr) output = output.concat("    " + s + "\n");

        return output;
    }

    public String[] getMenu()
    {
        int count = 0;

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select count(*) from menu where type_id = " + id); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            if (resultSet.next())
                count = resultSet.getInt("count");

            connection.close(); // Close connections
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] arr = new String[count];

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from menu where type_id = " + id); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
                arr[i++] = "Name: " + resultSet.getString("name") + ", Price: " + resultSet.getFloat("price");

            connection.close(); // Close connections
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }
}
