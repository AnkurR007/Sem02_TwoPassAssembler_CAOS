

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class pass1
{
    public static ArrayList<entry> table = new ArrayList<entry>();
    public static int LC=0;
    public static BufferedReader reader;
    static public void build_tables()
    {

        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\ankur\\IdeaProjects\\caos_assignment\\src\\sample.txt"));
            String linel = reader.readLine();
            String[] line;
            while (linel != null) {
                /*System.out.println(linel);*/
                line = linel.trim().split("\\s+");
                if(line.length >=4)
                {
                    throw_error();
                    continue;
                }
                if (linel.trim().length() <= 0) {
                    continue;
                }
                switch(line.length)
                {
                    case 1:one_length(line);break;
                    case 2:two_length(line);break;
                    case 3:three_length(line);break;
                    default:throw_error();System.out.println("switch");;break;
                }
                linel = reader.readLine();
                LC++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder intToString(int n)
    {
        StringBuilder bin=new StringBuilder();
        for(int i=0 ; i<4 ; i++)
        {
            bin.append(Integer.toString(n%2));
            n/=2;
        }
        return bin.reverse();
    }

    public static boolean isNumeric(String str)
    {
        if(str==null)
            return false;
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static StringBuilder intToString8(int n)
    {
        StringBuilder bin=new StringBuilder();
        for(int i=0 ; i<8 ; i++)
        {
            bin.append(Integer.toString(n%2));
            n/=2;
        }
        return bin.reverse();
    }

    public static void one_length(String[] inst)
    {
        entry temp = new entry(inst[0],LC);
        //System.out.println(temp);
        if(isNumeric(temp.field1))
        {
            throw_error();
            System.out.println(1);
            System.out.println("1");
        }
        if(!opcode_table.search_op(temp.field1))
        {
            throw_error();
            System.out.println(1);
        }
        table.add(temp);
        if(inst[0].equals("STP"))
        {
            update_symbol_table();
        }
    }
    public static void two_length(String[] inst)
    {
        entry temp = new entry(inst[0],inst[1],LC);
        //System.out.println(temp);
        if(isNumeric(temp.field1))
        {
            throw_error();
            System.out.println(2);
        }
        if(temp.field1.contains(":") && isNumeric(temp.field2))
        {
            throw_error();
            System.out.println(2);
        }
        if(temp.field1.contains(":") && opcode_table.search_op(temp.field2))
        {
            tables.symbol_table.add(new symbol(temp.field1,LC));
            table.add(temp);
        }
        else if(opcode_table.search_op(temp.field1))
        {
            if(isNumeric(temp.field2))
                tables.literal_table.add(new literal(Integer.parseInt(temp.field2),++LC));
            else
                tables.symbol_table.add(new symbol(temp.field2));
            table.add(temp);
        }

    }
    public static void three_length(String[] inst)
    {
        entry temp = new entry(inst[0],inst[1],inst[2],LC);
        //System.out.println(temp);
        if(isNumeric(temp.field1) || isNumeric(temp.field2) || !temp.field1.contains(":") || !opcode_table.search_op(temp.field2))
        {
            throw_error();
        }
        if(temp.field1.contains(":")) {
            symbol hapo = new symbol(temp.field1,LC);
            symbol.set_value(hapo, -1);
            tables.symbol_table.add(hapo);
        }
        if(isNumeric(temp.field3))
            tables.literal_table.add(new literal(Integer.parseInt(temp.field3),++LC));
        else if(!isNumeric(temp.field3))
            tables.symbol_table.add(new symbol(temp.field3));
        table.add(temp);
    }
    public static void throw_error()
    {
        System.out.println("error");
    }

    public static void update_symbol_table()
    {
        try {
            String linel = reader.readLine();
            LC++;
            String[] line = linel.trim().split("\\s+");
            while (linel != null) {
                /*System.out.println(linel);*/
                line = linel.trim().split("\\s+");
                if(line.length >=4)
                {
                    //throw error
                }
                if (linel.trim().length() <= 0) {
                    continue;
                }
                if(line.length != 3 || !(line[1].equals("DS") || line[1].equals("DW")) || !isNumeric(line[2]))
                {
                    throw_error();
                    continue;
                }
                symbol leeps = symbol.search_sym(line[0]);
                if(leeps==null) {
                    System.out.println("here "+line[0]);
                    throw_error();
                }
                symbol.set_address(leeps,LC);
                symbol.set_value(leeps,Integer.parseInt(line[2]));
                linel = reader.readLine();
                LC++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] argc)
    {
        build_tables();
//		tables.show_literal();
//		tables.show_symbol();
    }
}
