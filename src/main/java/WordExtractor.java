import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class WordExtractor {

    private String file;

    public WordExtractor(String file) {
        this.file = file;
    }

    public List<String> getAllWords() {
        List<String> words;
        String content = null;
        try {
            content = new Scanner(new File(file)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        words = Arrays.asList(content.split(" "));
        return words;
    }
}
