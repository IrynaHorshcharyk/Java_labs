import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String path= "src/text.txt";
        String text=readFile(new String(path));
        ArrayList<String> sentences=new ArrayList<String>();
        int start=0;
        int end=text.length();
        for(int i=0; i<text.length();i++){
            if(text.charAt(i)=='.'|| text.charAt(i)=='?'||text.charAt(i)=='!'){
                if(i!=text.length()-1) {
                    if(text.charAt(i+1)==' '){
                        end = i+1;
                        String sentence = text.substring(start, end);
                        start=end++;
                        sentences.add(sentence);
                    }
                }else{
                    end = i;
                    String sentence = text.substring(start, end);
                    sentences.add(sentence);
                }
            }
        }
        System.out.println("Text from file:");
        for(String s:sentences){
            System.out.println(s);
        }
        String lastSentense= sentences.get(sentences.size()-1);
        ArrayList<Integer> indexSentences=new ArrayList<Integer>();
        ArrayList<Word> tokens=new  ArrayList<Word>();
        ArrayList<Word> emails=new  ArrayList<Word>();
        ArrayList<Word> words=new  ArrayList<Word>();
        ArrayList<Token> wrongToken=new  ArrayList<Token>();
        for(String s:sentences){
            start=0;
            end=s.length();
         for(int i=0;i<s.length();i++){
             if(s.charAt(i)==' '){
                 if(i!=0 && i!=start){
                     end=i;
                     String word=s.substring(start,end);
                     words.add(new Word(word, sentences.indexOf(s)));
                     start=end+1;
                 }else{
                     start++;
                 }
             }
             if(s.charAt(i)=='.'|| s.charAt(i)=='?'|| s.charAt(i)=='!'){
                 if(i!=s.length()-1  ){
                     if(s.charAt(i+1)==' ' && i!=start ) {
                         end = i;
                         String word = s.substring(start, end);
                         words.add(new Word(word, sentences.indexOf(s)));
                         start = end;
                     }

                     }else{
                     end = i;
                     String word = s.substring(start, end);
                     words.add(new Word(word, sentences.indexOf(s)));
                     start = end;
                     }
             }
         }
        }


        tokens=FindTokens(words);
        for (Word token:tokens) {
            Token t=CheckEmail(token);
            if(t.IsEmail){
                emails.add(token);

            }else{
                wrongToken.add(t);
            }
        }

        for(int i=0;i< emails.size();i++){
           sentences.set(emails.get(i).Sentense,lastSentense);
        }

        System.out.println("Text after:");
        for(String s:sentences){
            System.out.println(s);
        }

        System.out.println("Emails:");
        for(Word e:emails){
            System.out.println(e.Text);
        }
        System.out.println("Wrong emails:");
        for(Token w:wrongToken){
            System.out.println(w.toString());
        }




    }
    public static String readFile(String path)
            throws IOException {
        StringBuilder result = new StringBuilder();

            Scanner input = new Scanner(new File(path));

            while (input.hasNext()) {
                String line = input.next();
                result.append(line+" ");
            }
            input.close();


        return result.toString();
    }
    public static ArrayList<Word> FindTokens(ArrayList<Word> words){
        ArrayList<Word> tokens=new  ArrayList<Word>();
        for (Word w:words) {
            for(int j=0;j< w.Text.length();j++)
                if(w.Text.charAt(j)=='@'){
                    tokens.add(w);
                    break;
                }
        }
        return tokens;
    }

    public static Token CheckEmail(Word token){
        int charA=-1;
        int charD=-1;
        int numberA=0;
        int numberD=0;
        for(int i=0;i<token.Text.length();i++){
            if(!CheckLetter(token.Text.charAt(i)))
                return new Token(token.Text,false,"містить символи окрім дозволених",token.Sentense);
            if(token.Text.charAt(i)=='@'){
                numberA++;
                charA=i;
            }
            if(token.Text.charAt(i)=='.'){
                numberD++;
                charD=i;
            }
        }
    if(charA==0)
    return new Token(token.Text,false,"як мінімум не містить символів перед @ ",token.Sentense);
    if(charD==token.Text.length()-1)
            return new Token(token.Text,false,"як мінімум не містить символів після @ ",token.Sentense);
    if(numberA!=1 )
            return new Token(token.Text,false,"як мінімум проблеми з кількістю @ ",token.Sentense);
    if(numberD<1)
            return new Token(token.Text,false,"як мінімум проблеми з крапками",token.Sentense);
    if(charD<charA)
            return new Token(token.Text,false,"як мінімум крапка раніше за знак  @ стоїть ",token.Sentense);


        return new Token(token.Text,true,"",token.Sentense);
    }
    public static boolean CheckLetter(char c){
        String alphabetWithUpper = "abcdefghijklmnopqrstuvwxyz" + "abcdefghijklmnopqrstuvwxyz".toUpperCase()+"0123456789" +"@"+".";
        char[] letters = alphabetWithUpper.toCharArray();
        for(int i=0;i<letters.length;i++){
            if(c==letters[i])
                return true;
        }
        return false;
    }

    static Boolean isSubstring(String s1, String s2)
    {
        int M = s1.length();
        int N = s2.length();

        for (int i = 0; i <= N - M; i++) {
            int j;

            for (j = 0; j < M; j++)
                if (s2.charAt(i + j) != s1.charAt(j))
                    break;

            if (j == M)
                return true;
        }

        return false;
    }
}
