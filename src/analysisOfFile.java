import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class analysisOfFile {
    public analysisOfFile() throws IOException {}

    private final String text = readFile();

    private String readFile() throws IOException {
//        String nameOfFile = "../Database.txt";
        File file = new File("./Database.txt");

        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String line, text = "";

        while((line = buffer.readLine()) != null){
            text += line + "\n";
        }
        return text;
    }
    public long amountOfCharacters(){
        long l = 0;
        int i =0;
        while(i < this.text.length()){
            if(!Character.isWhitespace(this.text.charAt(i)) && this.text.charAt(i) != '\n') l++;
            i++;
        }

        return l;
    }
    public long amountOfWhiteSpaces(){
        long l = 0;
        int i = 0;
        while(i < this.text.length()){
            if(Character.isWhitespace(this.text.charAt(i))) l++;
            i++;
        }
        return l;
    }
    public long amountOfLines(){
        long l = 0;
        int i = 0;
        while(i < this.text.length()){
            if(this.text.charAt(i) == '\n') l++;
            i++;
        }
        return l;

    }
    public long amountOfUpperCase(){
        long l = 0;
        int i = 0;
        while(i < this.text.length()){
            if(Character.isUpperCase(this.text.charAt(i))) l++;
            i++;
        }
        return l;
    }
    public long amountOfLowerCase(){
        long l = 0;
        int i = 0;
        while(i < this.text.length()){
            if(Character.isLowerCase(this.text.charAt(i))) l++;
            i++;
        }
        return l;
    }
    public long amountOfInterpunctionSigns(){
        int i = 0;
        int l = 0;
        String punctuations = ".,:;?!";

        while(i < this.text.length()){
            if(punctuations.contains(Character.toString(this.text.charAt(i)))) l++;
            i++;
        }
        return l;
    }
    public long amountOfDigitals(){
        int i = 0;
        int l = 0;

        while(i < this.text.length()){
            if(Character.isDigit(this.text.charAt(i))) l++;
            i++;
        }
        return l;
    }
    public long amountOfSentences() {
        long l = 0;
        int i = 0;
        String punctuations = ".?!";

        while (i < this.text.length()) {
            if(Character.isUpperCase(this.text.charAt(i))){
                i++;
                while(!punctuations.contains(Character.toString(this.text.charAt(i)))){
                    i++;
                }
                l++;
                i++;

            }else
                i++;
        }
        return l;
    }
}
