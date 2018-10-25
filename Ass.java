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
    public int indexTarget = 0;
    public String Address = "0000";
    public String[][] target = new String[2][2];

    public String[] op = new String[]{"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011",
                "1100", "1101", "1111"};
    public String[] opName = new String[]{"CLA", "LAC", "SAC", "ADD", "SUB", "BRZ", "BRN", "BRP", "INP", "DSP", "MUL", "MUL", "DIV", "STP",
                "DS", "DC"};


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
            System.out.println("Address "+ Address);
            System.out.println("Ye "+target[indexTarget][0]);

            target[indexTarget][1] = op[index];
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
            System.out.println("Ye "+target[indexTarget][0]);

            target[indexTarget][1] = op[index];
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
            System.out.println("Ye "+target[indexTarget][0]);

            target[indexTarget][1] = op[index];
            indexTarget += 1;
            GFG b = new GFG();
            Address=b.addBinary(Address, "1");
            }

            else {
            //agar koi nhi hai to!
            System.out.println("KOi nhi tha!!");
        }

    }
    public void display(){
        System.out.println();
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length; j++) {
                System.out.println("Addresses: "+ target[i][j]);

            }
            System.out.println("");
        }
    }
}


public class Ass {
    public static void main(String[] args) {
        functions f = new functions();
        String[] s = new String[]{"CLA"};
        String[] s2 = new String[]{"LAC"};
        f.lengthOne(s);
        f.lengthOne(s2);
        f.display();

        //Input Data//
        String [] [] input = new String[][] {
                { "LAC", "I"},
                { "ADD", "J"},
                { "SAC", "INTER"},
                { "LAC", "K"},
                { "ADD", "L"},
                { "MUL", "INTER"},
                { "STP"},
                {"I", "DS", "4"},
                {"L", "DS", "5"},
                {"K", "DS", "5"},
                {"L", "DS", "4"}  };
    }
}

