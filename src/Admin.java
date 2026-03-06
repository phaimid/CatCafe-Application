import java.sql.*;
import java.time.*;

public class Admin
{
    public static void registerUser(String username, String email, String password, String first_name, String last_name, String birth_date, String phone_number)
    {
        try {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator

            statement.execute("insert into users (username, email, password, first_name, last_name, birth_date, phone_number) values ('" +
                        username + "', '" + email + "', '" + password + "', '" + first_name + "', '" + last_name + "', '" + birth_date +
                        "', '" + phone_number + "');\n"); // The statement which adds the account

            connection.close();
        } catch (Exception e) {
            System.out.println("Account already exists!!!");
        }
    }

    public static boolean checkEmail(String email)
    {
        int index = email.indexOf("@gmail.com");
        int index2 = email.indexOf("'");
        return index != -1 && email.length() - index == 10 && index2 == -1;
    }

    public static boolean checkPhoneNumber(String phoneNumber)
    {
        char[] arr = phoneNumber.toCharArray();
        if (arr.length != 12) return false;

        for (int i = 0; i < 12; i++)
        {
            if ((i == 3 || i == 7) && arr[i] != '-') return false;
            if (i !=3 && i != 7 && (arr[i] < '0' || arr[i] > '9')) return false;
        }

        return true;
    }

    public static boolean checkDate(int day, int month, int year)
    {
        if (month == 2)
        {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {if (day > 29) return false;}
            else if (day > 28) return false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) return false;

        return true;
    }

    public static boolean checkReservationDate(int day, int month, int year, int hour, int minute)
    {
        String date = LocalDate.now().toString();
        String[] splitDate = date.split("[-]");
        int curyear = Integer.parseInt(splitDate[0]);
        int curmonth = Integer.parseInt(splitDate[1]);
        int curday = Integer.parseInt(splitDate[2]);

        String time = LocalTime.now().toString();
        String[] splitTime = time.split("[:]");
        int curhour = Integer.parseInt(splitTime[0]);
        int curminute = Integer.parseInt(splitTime[1]);

        if (curyear > year) return false;
        if (curyear == year && curmonth > month) return false;
        if (curyear == year && curmonth == month && curday > day) return false;
        if (curyear == year && curmonth == month && curday == day && curhour > hour) return false;
        if (curyear == year && curmonth == month && curday == day && curhour == hour && curminute > minute) return false;
        return true;
    }

    public static int userIdByName(String username)
    {
        int id = -1;

        try
        {
            // Select the element based on its name:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from users where username = '" + username + "'"); // The statement which will return the data we are looking for

            // Set the received data
            if (resultSet.next())
                id = resultSet.getInt("id");

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public static int userIdByEmail(String email)
    {
        int id = -1;

        try
        {
            // Select the element based on its name:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from users where email = '" + email + "'"); // The statement which will return the data we are looking for

            // Set the received data
            if (resultSet.next())
                id = resultSet.getInt("id");

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public static int userIdByPhone(String phone_number)
    {
        int id = -1;

        try
        {
            // Select the element based on its name:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from users where phone_number = '" + phone_number + "'"); // The statement which will return the data we are looking for

            // Set the received data
            if (resultSet.next())
                id = resultSet.getInt("id");

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public static User userByName(String username)
    {
        User user = null;

        try
        {
            // Select the element based on its name:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from users where username = '" + username + "'"); // The statement which will return the data we are looking for

            // Set the received data
            if (resultSet.next())
                user = new User(
                        resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("birth_date"), resultSet.getString("phone_number")
                );

            connection.close();// Close connections

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public static int catIdByName(String name)
    {
        int id = -1;

        try
        {
            // Select the element based on its name:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from cats where name = '" + name + "'"); // The statement which will return the data we are looking for

            // Set the received data
            if (resultSet.next())
                id = resultSet.getInt("id");

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public static Cat catByName(String name)
    {
        Cat cat = null;

        try
        {
            // Select the element based on its name:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from cats join cat_races on race_id = cat_races.id where name = '" + name + "'"); // The statement which will return the data we are looking for

            // Set the received data
            if (resultSet.next())
                cat = new Cat (
                        resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("race"), resultSet.getInt("isadopted") == 1
                );
            connection.close();// Close connections

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return cat;
    }

    public static int countCats()
    {
        int count = 0;

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select count(*) from cats"); // The statement which will return the data we are looking for

            // Set the received data
            resultSet.next();
            count = resultSet.getInt("count");

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int countCoffee()
    {
        int count = 0;

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select count(*) from coffee"); // The statement which will return the data we are looking for

            // Set the received data
            resultSet.next();
            count = resultSet.getInt("count");

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int countLocations()
    {
        int count = 0;

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select count(*) from locations"); // The statement which will return the data we are looking for

            // Set the received data
            resultSet.next();
            count = resultSet.getInt("count");

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int countShelters()
    {
        int count = 0;

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select count(*) from shelters"); // The statement which will return the data we are looking for

            // Set the received data
            resultSet.next();
            count = resultSet.getInt("count");

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int countUsers()
    {
        int count = 0;

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select count(*) from users"); // The statement which will return the data we are looking for

            // Set the received data
            resultSet.next();
            count = resultSet.getInt("count");

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int countTypes()
    {
        int count = 0;

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select count(*) from food_type"); // The statement which will return the data we are looking for

            // Set the received data
            resultSet.next();
            count = resultSet.getInt("count");

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static Cat[] getCats()
    {
        int count = Admin.countCats();
        Cat[] arr = new Cat[count];

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from cats join cat_races on race_id = cat_races.id"); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
            {
                arr[i++] = new Cat(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("race"), resultSet.getInt("isadopted") == 1);
            }

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }

    public static Coffee[] getCoffee()
    {
        int count = Admin.countCats();
        Coffee[] arr = new Coffee[count];

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from coffee join coffee_types on type_id = coffee_types.id join providers on provider_id = providers.id"); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
            {
                arr[i++] = new Coffee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("intensity"), resultSet.getFloat("weight"), resultSet.getString("type"), resultSet.getString("provider"));
            }

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }

    public static Locations[] getLocations()
    {
        int count = Admin.countLocations();
        Locations[] arr = new Locations[count];

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from locations"); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
            {
                arr[i++] = new Locations(resultSet.getInt("id"), resultSet.getString("address"), resultSet.getInt("seats"));
            }

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }

    public static Shelters[] getShelters()
    {
        int count = Admin.countShelters();
        Shelters[] arr = new Shelters[count];

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from shelters"); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
            {
                arr[i++] = new Shelters(resultSet.getInt("id"), resultSet.getString("address"));
            }

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }

    public static User[] getUsers()
    {
        int count = Admin.countUsers();
        User[] arr = new User[count];

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from users"); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
            {
                arr[i++] = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("birth_date"), resultSet.getString("phone_number"));
            }

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }

    public static FoodType[] getTypes()
    {
        int count = Admin.countTypes();
        FoodType[] arr = new FoodType[count];

        try
        {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from food_type"); // The statement which will return the data we are looking for

            // Set the received data
            int i = 0;
            while (resultSet.next())
            {
                arr[i++] = new FoodType(resultSet.getInt("id"), resultSet.getString("name"));
            }

            connection.close(); // Close connections
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return arr;
    }

    public static boolean validateAccount(String username, String password)
    {
        boolean check = false;

        try {
            // Select the element based on its id:
            Class.forName("org.postgresql.Driver"); // Establish driver
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "1234"); // Select database connection
            Statement statement = connection.createStatement(); // The sql translator
            ResultSet resultSet
                    = statement.executeQuery("select * from users where username = '" + username + "' and password = '" + password + "'"); // The statement which will return the data we are looking for

            // Check the values
            if (resultSet.next()) check = true;


            connection.close(); // Close connections
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
}

