import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

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
    public long amountOfWords(){
        long l = 0;
        int i = 0;
        while (i < this.text.length()) {
            while(Character.isAlphabetic(this.text.charAt(i))){
                i++;
                if(!Character.isAlphabetic(this.text.charAt(i))){
                    l++;
                }
            }
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
                while(!punctuations.contains(Character.toString(this.text.charAt(i))) && i < this.text.length() - 1){
                    i++;
                    if( i == this.text.length() - 1) l --;

                }
                l++;
                i++;

            }else
                i++;

        }
        return l;
    }
    public ArrayList<String> uniqueWords() {

        int i = 0;
        String word = "";
        String polishChars = "πÊÍ≥ÒÛúüø•∆ £—”åèØ";

        ArrayList<String> words = new ArrayList<>();
        while (i < this.text.length()) {
            if(Character.isAlphabetic(this.text.charAt(i)) || polishChars.contains(Character.toString(this.text.charAt(i)))){
                word += text.charAt(i);
            }else if(word!="") {

                    words.add(word);

                word = "";
            }

            i++;
        }
        words = new ArrayList<>(new LinkedHashSet<>(words));

        return words;
    }


        public ArrayList<String> uniqueDigits(){
        int i = 0;
        ArrayList<String> numbers = new ArrayList<>();
        while (i<this.text.length()){
            if(Character.isDigit(this.text.charAt(i))){
                numbers.add(Character.toString(this.text.charAt(i)));
                i++;
            }else{
                i++;
            }


        }
            numbers = new ArrayList<>(new LinkedHashSet<>(numbers));
            return numbers;
        }

}

