

import java.util.ArrayList;

public class opcode_table
{
    public int opcode;
    public String name;
    public static ArrayList<opcode_table> table;
    static int a=0;
    static {
        table = new ArrayList<opcode_table>();
        String[] names = {"CLA","LAC","SAC","ADD","SUB","BRZ","BRN","BRP","INP","DSP","MUL","DIV","STP"};
        for(int i=0 ; i<13 ; i++)
        {
            table.add(new opcode_table(names[i],(a)));
            a++;
            //System.out.println(names[i]+" "+a);
        }
    }
    public opcode_table(String s , int c)
    {
        name = s;
        opcode = c;
    }

    public static Boolean search_op(String op)
    {
        for(opcode_table temp : table)
        {
            if(temp.name.equals(op))
                return true;
        }
        return false;
    }

    public static opcode_table ret_ob(String name)
    {
        for(opcode_table temp : table)
        {
            if(temp.name.equals(name))
                return temp;
        }
        return null;
    }

    public static String ret_op(opcode_table temp)
    {
        return pass1.intToString(temp.opcode).toString();
    }
}
