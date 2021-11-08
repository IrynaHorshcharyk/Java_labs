import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextManager {
    public TextManager(String text){
    }
    public static List<String> ReadFromFile(String path) throws IOException {
        return  Arrays.stream(String.join("\n", Files
                                .readAllLines(Paths.get(path)))
                        .split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());
    }
    public static String Replace(String text){
        if(text.equals("")){
            System.out.println("\nFile empty");
            return "";
        }
        String result =  text.replaceAll("\\b([aA]|[Tt]he|[Oo]r|[aA]re|[ioIO]n|[Oo]ut)\\b", "").replaceAll(" +", " ");
        if(result.equals(text)){
            System.out.println("\n Заданих слів в тексті немає.");
        }
        return result;
    }
}
