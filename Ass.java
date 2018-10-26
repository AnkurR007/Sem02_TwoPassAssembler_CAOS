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
    public String Ssr="";
    public String Sname = "";
    public String SAddress="";

    public String[][] SymTbl = new String[5][3];

    public int getSsr() {
        for (int i = 0; i < SymTbl.length; i++) {
            if (SymTbl[i][0] == null) {
                return i;
            }
        }
        return -1;
    }


        public void display_SymTbl() {
        System.out.println("\n\tSYMBOL TABLE\n");

        for (int i = 0; i < SymTbl.length; i++) {
            System.out.println("Sr No: "+SymTbl[i][0]+"\tData: "+SymTbl[i][1]);
        }
    }
}

class LiteralTable{
    public int Lsr=0;
    public String Lname = "";
    public String LAddress="";
    public int[] pool = new int[10];

    public String[][] LitTbl = new String[5][3];

    public int getLsr() {
        for (int i = 0; i < LitTbl.length; i++) {
            if (LitTbl[i][0] == null) {
                return i;
            }
        }
        return -1;
    }

    public void display_LitTbl() {
        System.out.println("\n\tLiteral TABLE\n");

        for (int i = 0; i < LitTbl.length; i++) {
            System.out.println("Sr No: "+LitTbl[i][0]+"\tData: "+LitTbl[i][1]);
        }
    }

}


class functions {
    private int PC=0;
    public int indexTarget = 0;
    public String Address = "0000";
    public String[][] target = new String[5][3];

    public void setPC(int x) {
        this.PC=x;
    }
    public int getPC(){
        return this.PC;
    }


                                        //OPCODES////

    public String[] op = new String[]{"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011",
                "1100", "1101", "1111"};
    public String[] opName = new String[]{"CLA", "LAC", "SAC", "ADD", "SUB", "BRZ", "BRN", "BRP", "INP", "DSP", "MUL", "DIV", "STP",
                "DS", "DC"};



//******************************************************************\\

    public void passOne (String[][] in){

        if (in[0][0].equalsIgnoreCase("START")) {
            setPC(Integer.parseInt(in[0][1]));
        }
        else{
            setPC(500);
        }
        int tempe=0;
        while (tempe<in.length) {
            setPC(getPC()+1);
            if (in[tempe].length == 1) {
                lengthOne(in[tempe]);
            } else if (in[tempe].length == 2) {
                lengthTwo(in[tempe]);
            }
//            else if (in[tempe].length == 3) {
//                //lengthThree(in[tempe]);
//            }
            tempe++;
        }
    }

 //*****************************************************************************\\
        //WHEN THE INPUT INSTRUCTION IS     ONE_LENGTH     LONG//

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

    }


 //*******************************************************************\\
           //WHEN THE INPUT INSTRUCTION IS    TWO_LENGTH    LONG//

    public void lengthTwo(String[] s) {
        SymbolTable sym = new SymbolTable();
        LiteralTable lit = new LiteralTable();



        for (int i = 0; i < opName.length; i++) {
            if (s[0].equals(opName[i])) {           //If opcode

                target[indexTarget][0] = Address;
                target[indexTarget][1] = op[i];
                indexTarget+=1;
                GFG b = new GFG();
                Address=b.addBinary(Address,"1");
                //If First is an Opcode and second is a Symbol.
                if ( (s[1].charAt(0) >= 65 && s[1].charAt(0) <= 90)|| ( s[1].charAt(0) >= 97 && s[1].charAt(0) <= 122) ) {
                    int flag=0;
                    for (int j = 0; j < sym.SymTbl.length; j++) {
                        if (s[1] != sym.SymTbl[j][1]) {
                            flag=1;
                        }
                    }
                    if (flag == 1) {
                        int temp = sym.getSsr();

                        sym.SymTbl[temp][0] = Integer.toString(temp);
                        sym.SymTbl[temp][1] = s[1];
                    }
                } else if (s[1].charAt(0) == '=') {
                    int temp1 = lit.getLsr();
                    lit.LitTbl[temp1][0] = Integer.toString(temp1);
                    lit.LitTbl[temp1][1] = s[1];

                }
            }
            else if(s[1].equals(opName[i])) {               //If first is not an opcode
                                                    //Case 1 - X LAC

                target[indexTarget][0] = Address;
                target[indexTarget][1] = op[i];
                indexTarget+=1;
                GFG b = new GFG();
                Address=b.addBinary(Address,"1");


            }

        }
    }






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
                {"LAC"}, {"STP"}, {"LAC", "I"}, {"ADD", "J"}
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
        SymbolTable sym = new SymbolTable();
        LiteralTable lit = new LiteralTable();
        sym.display_SymTbl();;
        lit.display_LitTbl();

    }
}

