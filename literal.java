

public class literal
{
    public int value;
    public int address=-1;

    public literal(int val)
    {
        value = val;
    }
    public literal(int val,int add)
    {
        value = val;
        address = add;
    }
    public static literal search_lit(int val)
    {
        for(literal temp : tables.literal_table)
        {
            if(temp.value == val)
                return temp;
        }
        return null;
    }

    public static Boolean verify_op(String op)
    {
        for(literal temp : tables.literal_table)
        {
            if(temp.value == Integer.parseInt(op))
                return true;
        }
        return false;
    }

    public static void set_address(literal temp , int add)
    {
        temp.address = add;
    }
    @Override
    public String toString()
    {
        if(address!=-1)
            return value+" "+pass1.intToString8(address).toString();
        else
            return Integer.toString(value);
    }
}
