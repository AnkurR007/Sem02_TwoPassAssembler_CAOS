import java.util.*;

class GFG {

    public static String addBinary(String a, String b) {
        String result = "";

        int s = 0;

        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {

            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);

            result = (char) (s % 2 + '0') + result;
            s /= 2;
            i--;
            j--;
        }
        return result;
    }
}

class SymbolTable{
    public int Ssr=0;
    public String Sname = "";
    public String SAddress="";



}

class LiteralTable{
    public int Lsr=0;
    public String Lname = "";
    public String LAddress="";
    public int[] pool = new int[10];



}


class functions {
    private int PC=0;
    public int indexTarget = 0;
    public String Address = "0000";
    public String[][] target = new String[20][2];

    public void setPC(int x) {
        this.PC=x;
    }

    public String[] op = new String[]{"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011",
                "1100", "1101", "1111"};
    public String[] opName = new String[]{"CLA", "LAC", "SAC", "ADD", "SUB", "BRZ", "BRN", "BRP", "INP", "DSP", "MUL", "DIV", "STP",
                "DS", "DC"};

    public void passOne (String[][] in){

        if (in[0][0].equalsIgnoreCase("START")) {
            setPC(Integer.parseInt(in[0][1]));
        }
        else{
            setPC(500);
        }
        int tempe=0;
        while (tempe<in.length) {
            if (in[tempe].length == 1) {
                lengthOne(in[tempe]);
            } else if (in[tempe].length == 2) {
               // lengthTwo(in[tempe]);
            } else if (in[tempe].length == 3) {
                //lengthThree(in[tempe]);
            }
            tempe++;
        }
    }
 //****************************************************\\
    //WHEN THE INPUT INSTRUCTION IS ONE_LENGTH LONG//

    public void lengthOne(String[] s) {
        if (s[0].equals("CLA")) {
            int index = -1;
            for (int i = 0; i < opName.length; i++) {
                if (opName[i] == s[0]) {
                    index = i;
                    break;
                }
            }

            target[indexTarget][0] = Address;
            System.out.println("Address:"+ Address);

            target[indexTarget][1] = op[index];
            System.out.println("OPcode :"+op[index]);
            indexTarget += 1;
            GFG b = new GFG();
            Address=b.addBinary(Address, "1");
        }

        else if (s[0].equals("LAC")) {
            int index = -1;
            for (int i = 0; i < opName.length; i++) {
                if (opName[i] == s[0]) {
                    index = i;
                    break;
                }
            }
            target[indexTarget][0] = Address;
            System.out.println("Address "+ Address);

            target[indexTarget][1] = op[index];
            System.out.println("OPcode :"+op[index]);
            indexTarget += 1;
            GFG b = new GFG();
            Address=b.addBinary(Address, "1");
        }

        else if (s[0].equals("STP")) {
            int index = -1;
            for (int i = 0; i < opName.length; i++) {
                if (opName[i] == s[0]) {
                    index = i;
                    break;
                }
            }
            target[indexTarget][0] = Address;
            System.out.println("Address "+ Address);

            target[indexTarget][1] = op[index];
            System.out.println("OPcode :"+op[index]);
            indexTarget += 1;
            GFG b = new GFG();
            Address=b.addBinary(Address, "1");
            }

            else {
            //agar koi nhi hai to!
            System.out.println("KOi nhi tha!!");
        }

    }

 //****************************************************\\
    //WHEN THE INPUT INSTRUCTION IS TWO_LENGTH LONG//
    //public void






    public void display(){
        System.out.println();
        for (int i = 0; i < target.length; i++) {
            System.out.println("Addresses: "+ target[i][0] +"\tOpcode: "+target[i][1]);
        }
        System.out.println("");
    }
}


public class Ass {
    public static void main(String[] args) {
        functions f = new functions();
        String[] s = new String[]{"CLA"};
        String[] s2 = new String[]{"LAC"};
//        f.lengthOne(s);
//        f.lengthOne(s2);
//        f.display();

        //Input Data//
        String [] [] input = new String[][] {
                {"LAC"}, {"STP"}
//                { "LAC", "I"},
//                { "ADD", "J"},
//                { "SAC", "INTER"},
//                { "LAC", "K"},
//                { "ADD", "L"},
//                { "MUL", "INTER"},
//                { "STP"},
//                {"I", "DS", "4"},
//                {"L", "DS", "5"},
//                {"K", "DS", "5"},
//                {"L", "DS", "4"}
        };
        f.passOne(input);
        f.display();

    }
}

