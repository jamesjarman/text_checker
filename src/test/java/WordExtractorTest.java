import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class WordExtractorTest {

    @Test
    public void testWordsAreReadFromAFile() {
        WordExtractor extractor = new WordExtractor(FilePathConstants.ESSAY);
        List<String> allWords = extractor.getAllWords();
        assertFalse(allWords.isEmpty());
    }

}
