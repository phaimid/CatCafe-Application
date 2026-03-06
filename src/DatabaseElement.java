public abstract class DatabaseElement
{
    protected int id;
    protected String name;

    public DatabaseElement(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    abstract public int getID();
    abstract public String getName();
    abstract public String printData();
}
