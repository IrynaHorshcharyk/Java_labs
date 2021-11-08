import java.io.*;
/* Видалити з тексту всі слова, які є артиклями в англійській мові (a, the),
а також слова or, are, on, in, out та вивести результуючий текст . */
public class Main {
    public static void main(String[] args) throws IOException {

        String path = "src/text.txt";
        String text = String.join("\n", TextManager.ReadFromFile(path));

        if(text.equals("")){

        }else{
            System.out.println("Text from file\n");
            System.out.println(text);
            TextManager textManager = new TextManager(text);
            System.out.println("Text after replace\n");
            text=textManager.Replace(text);
            System.out.println(text);
        }
    }
}
