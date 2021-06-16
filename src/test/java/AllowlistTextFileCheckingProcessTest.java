import com.jarman.extract.data.ProblematicWordCsvReader;
import com.jarman.extract.data.ProblematicWordReader;
import com.jarman.extract.text.Extractor;
import com.jarman.extract.text.WordExtractor;
import com.jarman.processes.AllowlistTextFileCheckingProcess;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.jarman.FilePathConstants.*;
import static org.junit.Assert.assertEquals;

public class AllowlistTextFileCheckingProcessTest {

    @Test
    public void testHappyPathForCsvReader() {
        Extractor textFileExtractor = new WordExtractor(BLACKLIST);
        ProblematicWordReader problematicWordReader = new ProblematicWordCsvReader();
        AllowlistTextFileCheckingProcess runner = new AllowlistTextFileCheckingProcess(textFileExtractor, problematicWordReader, RESULTS);
        runner.runProcess();

        String content = "";
        String expectedContent = "You may want to consider replacing blacklist with denylist because you may want to avoid associating black/white with bad/good.";

        {
            try {
                content = new Scanner(new File(RESULTS)).useDelimiter("\\Z").next();
            } catch (FileNotFoundException f) {
                f.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        assertEquals(content, expectedContent);
    }


}
