import com.jarman.load.TextFileResultsWriter;
import com.jarman.pojos.ProblematicWord;
import com.jarman.service.ResultsCreator;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

import static com.jarman.FilePathConstants.RESULTS_FILE;

public class TextFileResultsWriterTest {


    @Test
    public void testFileIsWrittenToWhenThereIsOneProblematicWord() {
        ProblematicWord problematicWord = new ProblematicWord("blacklist", "denylist", "you may want to avoid associating black/white with bad/good.");
        List<ProblematicWord> problematicWords = new java.util.ArrayList<>();
        problematicWords.add(problematicWord);
        ResultsCreator resultsCreator = new ResultsCreator(problematicWords);
        String results = resultsCreator.getResults();
        TextFileResultsWriter textFileResultsWriter = new TextFileResultsWriter(results, RESULTS_FILE);
        textFileResultsWriter.writeResultsToFile();
        String expectedResults = "There was 1 potentially problematic word in your text. You may want to consider replacing blacklist with denylist because you may want to avoid associating black/white with bad/good.";

        String actualResults="";
        try {
            actualResults = new Scanner(new File(RESULTS_FILE)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(actualResults,expectedResults);
    }


    @Test
    public void testFileIsWrittenToWhenThereAreNoProblematicWords() {
        List<ProblematicWord> problematicWords = new java.util.ArrayList<>();
        ResultsCreator resultsCreator = new ResultsCreator(problematicWords);
        String results = resultsCreator.getResults();
        TextFileResultsWriter textFileResultsWriter = new TextFileResultsWriter(results, RESULTS_FILE);
        textFileResultsWriter.writeResultsToFile();
        String expectedResults = "There were no problematic words in your text.";

        String actualResults="";
        try {
            actualResults = new Scanner(new File(RESULTS_FILE)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(actualResults,expectedResults);
    }


}

