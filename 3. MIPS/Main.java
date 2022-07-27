import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    static String file = "assembly.txt";

    public static void main(String[] args) {
        String in = "";
        MIPS mips = new MIPS();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(true){
                in = reader.readLine();

                if(in == null) break;

                mips.generateMIPS(in);
            }

            mips.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
