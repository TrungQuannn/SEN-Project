package engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

public class Word {
    private String prefix;
    private String suffix;
    private String text;
    public Word(String prefix, String text, String suffix){
        this.prefix = prefix;
        this.text= text;
        this.suffix = suffix;
    }

    public static Set<String> stopWords;
    public static Word createWord(String rawText){
        if( rawText == null|| rawText.isEmpty()) {
                return new Word("",rawText,"");
        }
        // prefix
        int prefixCount = 0;
        //prefix chay tu dau, khong phai text/ number
        while (prefixCount < rawText.length()&& !Character.isLetterOrDigit
                (rawText.charAt(prefixCount))){
            prefixCount++;
        }
        String prefix = rawText.substring(0, prefixCount);
    //suffix bo qua prefix, cung 1 dieu kien voi prefix
        int suffixCount = rawText.length();
        while(suffixCount > prefixCount&&!Character.isLetterOrDigit
                (rawText.charAt(suffixCount-1))){
            //lay dan dan tu gia tri cuoi, cho den khi gap 1 ki tu chu/ so
            suffixCount--;
        }
        String suffix = rawText.substring(suffixCount);
        //text(dong con lai) nam giua pre-suf
        String text = rawText.substring(prefixCount, suffixCount);
        if(text.endsWith("'s")){
            text =text.substring(0, text.length()-2);
            suffix = "'s"+ suffix;
        }
        //invalid
        if(!text.matches(".*[a-zA-Z].*")){
            return new Word("",rawText,"");
        }
        return new Word(prefix,text,suffix);
    }

    public boolean isKeyword(){
        //text khong duoc trong/ null, phai co ki tu, phai duoc co trong stopword
        if(text!=null && !text.isEmpty()&&text.matches(".*[a-zA-Z].*")
                &&(stopWords==null||!stopWords.contains(text.toLowerCase()))){
       return true;
        }
            return false;
        }

    public String getPrefix(){
        return prefix;
    }
    public String getSuffix(){
        return suffix;
    }
    public String getText(){
        return text;
    }
    public static boolean loadStopWords(String fileName){
        //buffered de doc file (stopwords.txt)
        stopWords = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String theLine;
            //xoa cach dong + them vao stopwords
            while((theLine= br.readLine())!=null){
                theLine = theLine.trim();
                if (!theLine.isEmpty()){
                    stopWords.add(theLine.toLowerCase());
                }
}
                return true;
        }catch(IOException e){
            return false;
        }
    }
    public boolean equals (Object o){
       if(this ==o) {
           return true;
       }
       if(!(o instanceof Word)) {
           return false;
    }
       Word secondO = (Word) o;
       //check 2 Words
        if (this.text == null && secondO.text == null) return true;
        if (this.text == null || secondO.text == null) return false;
       return this.text.equalsIgnoreCase(secondO.text);
    }

    @Override
    public String toString() {
        return prefix + text + suffix;
    }
}
