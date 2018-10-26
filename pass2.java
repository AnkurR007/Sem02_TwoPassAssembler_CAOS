
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class pass2
{
    public static void translate()
    {
        System.out.println("Object code ....");
        System.out.println();
        for(entry temp : pass1.table)
        {
            String address = pass1.intToString8(temp.address).toString();
            String opcode="";
            //System.out.println(temp);
            if(opcode_table.search_op(temp.field1))
            {
                opcode = opcode_table.ret_op(opcode_table.ret_ob(temp.field1));
            }
            else if(opcode_table.search_op(temp.field2))
            {
                opcode = opcode_table.ret_op(opcode_table.ret_ob(temp.field2));
            }
            else
                pass1.throw_error();
            String operand="";
            if(symbol.verify_sym(temp.field2) || pass1.isNumeric(temp.field2))
            {
                if(symbol.verify_sym(temp.field2))
                    operand = pass1.intToString8(symbol.search_sym(temp.field2).address).toString();
                else
                    operand = pass1.intToString8(literal.search_lit(Integer.parseInt((temp.field2))).address).toString();
            }
            else if(symbol.verify_sym(temp.field3) || pass1.isNumeric(temp.field3))
            {
                if(symbol.verify_sym(temp.field3))
                    operand = pass1.intToString8(symbol.search_sym(temp.field3).address).toString();
                else
                    operand = pass1.intToString8(literal.search_lit(Integer.parseInt((temp.field3))).address).toString();
            }
            System.out.println(address+" "+opcode+" "+operand);

        }
    }

    public static void write_to_file()
    {
        BufferedWriter bufferedWriter = null;
        try
        {
            String s;
            File myFile = new File("Output.txt");
            myFile.createNewFile();

            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);
            for(entry temp : pass1.table)
            {
                String address = pass1.intToString8(temp.address).toString();
                String opcode="";
                //System.out.println(temp);
                if(opcode_table.search_op(temp.field1))
                {
                    opcode = opcode_table.ret_op(opcode_table.ret_ob(temp.field1));
                }
                else if(opcode_table.search_op(temp.field2))
                {
                    opcode = opcode_table.ret_op(opcode_table.ret_ob(temp.field2));
                }
                else
                    pass1.throw_error();
                String operand="";
                if(symbol.verify_sym(temp.field2) || pass1.isNumeric(temp.field2))
                {
                    if(symbol.verify_sym(temp.field2))
                        operand = pass1.intToString8(symbol.search_sym(temp.field2).address).toString();
                    else
                        operand = pass1.intToString8(literal.search_lit(Integer.parseInt((temp.field2))).address).toString();
                }
                else if(symbol.verify_sym(temp.field3) || pass1.isNumeric(temp.field3))
                {
                    if(symbol.verify_sym(temp.field3))
                        operand = pass1.intToString8(symbol.search_sym(temp.field3).address).toString();
                    else
                        operand = pass1.intToString8(literal.search_lit(Integer.parseInt((temp.field3))).address).toString();
                }
                //System.out.println(s=address+" "+opcode+" "+operand);
                s=address+" "+opcode+" "+operand;
                bufferedWriter.write(s);
                bufferedWriter.write("\r\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            if(bufferedWriter != null) bufferedWriter.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] argc)
    {
        pass1.build_tables();
        tables.show_literal();
        tables.show_symbol();
        translate();
        write_to_file();
    }
}
