import com.jarman.extract.text.WordExtractor;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.jarman.FilePathConstants.*;
import static org.junit.Assert.*;

public class WordExtractorTest {


    @Test
    public void testWordsAreReadFromAFile() {
        WordExtractor extractor = new WordExtractor(LOREM);
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

}
