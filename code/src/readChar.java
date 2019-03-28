package src;
import java.io.*;

public class readChar {

    private int l = 0;

    public static void main(String[] args)throws Exception {
        System.out.println(showAmountOfChars());

    }

    public static String readFile()throws Exception{
        File file = new File("C:\\Users\\Klosiek\\Desktop\\AiSD_Projekt\\code\\file.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line, text = "";

        while((line = br.readLine()) != null){
            text +=  line;
            System.out.println(text);
            l++;
        }
        return text;

    }

    public static long showAmountOfChars()throws Exception{
        String text = readFile();
        if(text.isEmpty()) return 0;

        return text.length();
    }
}
