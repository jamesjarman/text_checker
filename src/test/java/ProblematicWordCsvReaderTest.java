import com.jarman.extract.data.ProblematicWordCsvReader;
import com.jarman.extract.data.ProblematicWordReader;
import com.jarman.pojos.ProblematicWord;
import org.junit.Test;

import java.util.List;

import static com.jarman.FilePathConstants.*;
import static org.junit.Assert.assertEquals;

public class ProblematicWordCsvReaderTest {


    @Test
    public void testExtractorWorksWithHappyPath() {
        ProblematicWordReader csvExtractor = new ProblematicWordCsvReader();
        List<ProblematicWord> problematicWords = csvExtractor.getAllProblematicWords(ALLOWLIST);
        assertEquals(problematicWords.size(), 2);
    }

    @Test
    public void testExtractorWorksForEmptyCsv() {
        ProblematicWordReader csvExtractor = new ProblematicWordCsvReader();
        List<ProblematicWord> problematicWords = csvExtractor.getAllProblematicWords(EMPTY);
        assertEquals(problematicWords.size(), 0);
    }

    @Test
    public void testExtractorHandlesMissingCsv() {
        ProblematicWordReader csvExtractor = new ProblematicWordCsvReader();
        List<ProblematicWord> problematicWords = csvExtractor.getAllProblematicWords(NON_EXISTENT_FILE);
        assertEquals(problematicWords.size(), 0);
    }



}

