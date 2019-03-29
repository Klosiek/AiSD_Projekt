import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class analysisOfFile {
    public analysisOfFile() throws IOException {}

    private final String text = readFile();

    private String readFile() throws IOException {
        String nameOfFile = "C:/Users/Klosiek/Desktop/AiSD_Projekt/Database.txt";
        File file = new File(nameOfFile);

        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String line, text = "";
        int i = 0;

        while((line = buffer.readLine()) != null){
            text += line;
        }
        return text;
    }
    public long amountOfCharacters(){
        long l = 0;
        int i =0;
        while(i < this.text.length()){
            if(!Character.isWhitespace(this.text.charAt(i))) l++;
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
    public long amountOfLines(){ // CHUJ WIE NIC NIE DZIALA
        String[] lines = this.text.split("\r\n|\r|\n, -1");
        return lines.length;
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
        String punctuations = ".,:;";

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
    public long amountOfWords(){ // NA POZNIEJ
        long l = 0;
        int i = 0;
        String words = ".,:; ";
        String ignore = ", ";
        while(i < this.text.length()){
                if(words.contains(Character.toString(this.text.charAt(i)))) l++;
            i++;
        }
        return l;
    }
}
