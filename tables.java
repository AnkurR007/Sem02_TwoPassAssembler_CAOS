

import java.util.ArrayList;

public class tables
{
    public static ArrayList<literal> literal_table;
    public static ArrayList<symbol> symbol_table;
    static {
        literal_table = new ArrayList<literal>();
        symbol_table = new ArrayList<symbol>();
    }

    public static void show_literal()
    {
        System.out.println("Showing literal table ....");
        System.out.println();
        for(literal temp : literal_table)
        {
            System.out.println(temp);
        }
        System.out.println();
    }

    public static void show_symbol()
    {
        System.out.println("Showing symbol table ....");
        System.out.println();
        for(symbol temp : symbol_table)
        {
            System.out.println(temp);
        }
        System.out.println();
    }
}
