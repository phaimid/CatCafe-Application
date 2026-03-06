import java.sql.*;

public class Shelters extends DatabaseElement
{
    public Shelters(int id, String name)
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
        return "Address: " + name;
    }
}