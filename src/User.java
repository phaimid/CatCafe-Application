import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User extends DatabaseElement
{
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String birth_date;
    private String phone_number;

    public User(int id, String name, String email, String password, String first_name, String last_name, String birth_date, String phone_number)
    {
        super(id, name);
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.phone_number = phone_number;
    }

    public int getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public String getBirth_date()
    {
        return birth_date;
    }

    public String getPhone_number()
    {
        return phone_number;
    }

    public String printData()
    {
        return
                "Username: " + name + ", Email: " + email + ", Password: " + password +
                ", First name: " + first_name + ", Last name: " + last_name +
                ", Birth date: " + birth_date + ", Phone number: " + phone_number;
    }
}
