import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Main {
    static String file = "assembly.txt";
    static HashMap<String, Integer> mp = new HashMap<>();

    public static void main(String[] args) {
        int line_count = 0;
        String in = "";
        MIPS mips = new MIPS();

        scanForLabels();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(true){
                in = reader.readLine();

                if(in == null) break;

                mips.generateMIPS(in, line_count);
            }

            line_count++;
            mips.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void scanForLabels(){
        int line_count = 0;
        String in = "";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(true){
                in = reader.readLine();

                if(in == null) break;

                String[] arr = in.split(" ");

                if(arr[0].charAt(arr[0].length()-1) == ':'){
                    String label = arr[0].substring(0, arr[0].length()-1);
                    mp.put(label, line_count);
                }

                line_count++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
