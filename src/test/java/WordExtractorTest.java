import com.jarman.extract.data.ProblematicWordCsvReader;
import com.jarman.extract.data.ProblematicWordReader;
import com.jarman.extract.text.Extractor;
import com.jarman.extract.text.WordExtractor;
import com.jarman.pojos.ProblematicWord;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.jarman.FilePathConstants.*;
import static org.junit.Assert.*;

public class WordExtractorTest {


    @Test
    public void testWordsAreReadFromAFile() {
        Extractor extractor = new WordExtractor(LOREM);
        List<String> allWords = extractor.getAllWords();
        assertFalse(allWords.isEmpty());
    }

    @Test
    public void testNothingIsReturnedFromAnEmptyFile() {
        WordExtractor extractor = new WordExtractor(EMPTY);
        List<String> allWords = extractor.getAllWords();
        assertTrue(allWords.isEmpty());
    }

    @Test
    public void testMissingFilesAreHandled() {
        WordExtractor extractor = new WordExtractor(NON_EXISTENT_FILE);
        List<String> allWords = extractor.getAllWords();
        assertTrue(allWords.isEmpty());
    }

    @Test
    public void testExpectedWordsAreExtracted() {
        WordExtractor extractor = new WordExtractor(LOREM);
        List<String> allWords = extractor.getAllWords();
        List<String> expectedWords = Arrays.asList("Lorem", "etc");
        assertEquals(allWords,expectedWords);
    }

    @Test
    public void testThatPunctuationIsIgnored() {
        WordExtractor extractor = new WordExtractor(BLACKLIST_WITH_COMMAS);
        List<String> allWords = extractor.getAllWords();
        List<String> expectedWords = Arrays.asList("you're", "on","the", "blacklist", "so", "you", "can't", "come", "in");
        assertEquals(allWords,expectedWords);
    }

}
