

public class entry
{
    public String field1,field2,field3;
    public int address;

    public entry(String field1,int lc)
    {
        this.field1 = field1;
        address = lc;
    }
    public entry(String field1,String field2,int lc)
    {
        this.field1 = field1;
        this.field2 = field2;
        address = lc;
    }
    public entry(String field1,String field2 , String field3,int lc)
    {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        address = lc;
    }
    @Override
    public String toString()
    {
        return field1+" "+field2+" "+field3;
    }
}
