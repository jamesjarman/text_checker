import com.jarman.load.TextFileResultsWriter;
import com.jarman.pojos.ProblematicWord;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

import static com.jarman.FilePathConstants.RESULTS;

public class TextFileResultsWriterTest {

    @Test
    public void testStuff() {
        System.out.println("");

    }

    @Test
    public void testFileIsWrittenToWhenThereIsOneProblematicWord() {
        ProblematicWord problematicWord = new ProblematicWord("blacklist", "denylist", "you may want to avoid associating black/white with bad/good.");
        List<ProblematicWord> problematicWords = new java.util.ArrayList<>();
        problematicWords.add(problematicWord);
        TextFileResultsWriter textFileResultsWriter = new TextFileResultsWriter(problematicWords,RESULTS);
        textFileResultsWriter.writeResultsToFile();
        String expectedResults = "You may want to consider replacing blacklist with denylist because you may want to avoid associating black/white with bad/good.";

        String actualResults="";
        try {
            actualResults = new Scanner(new File(RESULTS)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(actualResults,expectedResults);
    }

    // TODO add tests
    // add a test for multiple problematic words

    // add a test for no problematic words

    // punctuation

    // other word forms

}

