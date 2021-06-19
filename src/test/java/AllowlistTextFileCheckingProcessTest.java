import com.jarman.extract.data.ProblematicWordCsvReader;
import com.jarman.extract.data.ProblematicWordDbReader;
import com.jarman.extract.data.ProblematicWordReader;
import com.jarman.extract.text.Extractor;
import com.jarman.extract.text.WordExtractor;
import com.jarman.processes.AllowlistTextFileCheckingProcess;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.jarman.FilePathConstants.BLACKLIST;
import static com.jarman.FilePathConstants.RESULTS_FILE;
import static org.junit.Assert.assertEquals;

public class AllowlistTextFileCheckingProcessTest {

    @Test
    public void testHappyPathForCsvReader() {
        Extractor textFileExtractor = new WordExtractor(BLACKLIST);
        ProblematicWordReader problematicWordReader = new ProblematicWordCsvReader();
        AllowlistTextFileCheckingProcess runner = new AllowlistTextFileCheckingProcess(textFileExtractor, problematicWordReader, RESULTS_FILE);
        runner.runProcessWithCsv();

        String actualContents = getActualContents();
        String expectedContents = "There was 1 potentially problematic word in your text. You may want to consider replacing blacklist with denylist because you may want to avoid associating black/white with bad/good.";

        assertEquals(actualContents, expectedContents);
    }

    @Test
    public void testHappyPathForDbReader() {
        Extractor textFileExtractor = new WordExtractor(BLACKLIST);
        ProblematicWordReader problematicWordReader = new ProblematicWordDbReader();
        AllowlistTextFileCheckingProcess runner = new AllowlistTextFileCheckingProcess(textFileExtractor, problematicWordReader, RESULTS_FILE);
        runner.runProcessWithDb();

        String actualContents = getActualContents();
        String expectedContents = "There was 1 potentially problematic word in your text. You may want to consider replacing blacklist with denylist because you may want to avoid associating black/white with bad/good.";

        assertEquals(actualContents, expectedContents);
    }

    private String getActualContents() {
        String actualContents = "";
        {
            try {
                actualContents = new Scanner(new File(RESULTS_FILE)).useDelimiter("\\Z").next();
            } catch (FileNotFoundException f) {
                f.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return actualContents;
    }

}
