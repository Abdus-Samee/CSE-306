import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MIPS {
    String file = "mips.txt";
    BufferedWriter writer;

    public MIPS(){
        try {
            writer = new BufferedWriter(new FileWriter(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateMIPS(String code){
        String[] arr = code.split(" ");

        if(arr[0]!="j"&&arr[0]!="beq"&&arr[0]!="bneq") RSIFormat(arr);
        else JFormat(arr);
    }

    /**
     *  R -> add $t1, $t2, $zero
     *  S -> sll $t4, $t3, 3
     *  I -> sw $t0, 5($t2), addi $t3, $zero, $t0
     * */
    public void RSIFormat(String[] arr){
        String opcode = "";
        String reg1 = "";
        String reg2 = "";
        String fourth = "";

        if(arr[0].equals("add")||arr[0].equals("sub")||arr[0].equals("and")||arr[0].equals("or")||arr[0].equals("nor")){
            opcode = OpCode.valueOf(arr[0]).getCode();
            reg1 = RegCode.valueOf(getReg(arr[1])).getCode();
            reg2 = RegCode.valueOf(getReg(arr[2])).getCode();
            fourth = RegCode.valueOf(getReg(arr[3])).getCode();
        }else if(arr[0].equals("sll")||arr[0].equals("srl")||arr[0].equals("addi")||arr[0].equals("subi")||arr[0].equals("andi")||arr[0].equals("ori")){
            opcode = OpCode.valueOf(arr[0]).getCode();
            reg1 = RegCode.valueOf(getReg(arr[1])).getCode();
            reg2 = RegCode.valueOf(getReg(arr[2])).getCode();
            fourth = intToBinary(arr[3]);
        }else{
            opcode = OpCode.valueOf(arr[0]).getCode();
            reg1 = RegCode.valueOf(getReg(arr[1])).getCode();
            String[] ar = arr[2].split("\\s*[()]\\s*");
            reg2 = RegCode.valueOf(getReg(ar[1])).getCode();
            fourth = intToBinary(ar[0]);
        }

        try {
            writer.write(opcode + " " + reg1 + " " + reg2 + " " + fourth + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void JFormat(String[] arr){

    }

    public String getReg(String op){
        if(op.charAt(op.length()-1) != ',') return op;
        return op.substring(0, op.length()-1);
    }

    public String intToBinary(String num){
        String fourth = Integer.toString(Integer.parseInt(num), 2);
        if(fourth.length() != 4){
            String prefix = new String(new char[4-fourth.length()]).replace("\0", "0");
            fourth = prefix + fourth;
        }

        return fourth;
    }

    public void close() {
        try {
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
