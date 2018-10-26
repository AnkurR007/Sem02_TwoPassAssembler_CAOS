

public class symbol
{
    public String name;
    public int address=-1;
    public int value;

    public symbol(String s)
    {
        name =s;
    }
    public symbol(String s,int add)
    {
        name =s;
        address = add;
    }


    public static symbol search_sym(String nam)
    {
        for(symbol temp : tables.symbol_table)
        {
            if(temp.name.equals(nam))
                return temp;
        }
        return null;
    }

    public static Boolean verify_sym(String op)
    {
        for(symbol temp : tables.symbol_table)
        {
            if(temp.name.equals(op))
                return true;
        }
        return false;
    }

    public static void set_address(symbol temp , int add)
    {
        temp.address = add;
    }
    public static void set_value(symbol temp , int val)
    {
        temp.value = val;
    }
    @Override
    public String toString()
    {
        if(address!=-1)
            return name+" "+pass1.intToString8(address).toString()+" "+value;
        else
            return name;
    }
}
