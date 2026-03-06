import java.sql.*;

public class Coffee extends DatabaseElement
{
    private int intensity;
    private float weight;
    private String type;
    private String provider;

    public Coffee(int id, String name, int intensity, float weight, String type, String provider)
    {
        super(id, name);
        this.intensity = intensity;
        this.weight = weight;
        this.type = type;
        this.provider = provider;
    }

    public int getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getIntensity()
    {
        return intensity;
    }

    public float getWeight()
    {
        return weight;
    }

    public String getType()
    {
        return type;
    }

    public String getProvider()
    {
        return provider;
    }

    public String printData()
    {
        return
                "Name: " + name + ", Intensity: " + intensity + ", Weight: " + weight +
                ", Type: " + type + ", Provider: " + provider;
    }
}
