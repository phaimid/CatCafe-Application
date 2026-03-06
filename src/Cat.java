public class Cat extends DatabaseElement
{

    private String race;
    private boolean isAdopted;

    public Cat (int id, String name, String race, boolean isAdopted)
    {
        super(id, name);
        this.race = race;
        this.isAdopted = isAdopted;
    }

    public int getID() // simple get function
    {
        return id;
    }

    public String getName() // simple get function
    {
        return name;
    }

    public String getRace()
    {
        return race;
    }

    public boolean getIsAdopted()
    {
        return isAdopted;
    }

    public String printData()
    {
        return "Name: " + name + ", Race: " + race;
    }
}
