import com.jarman.extract.data.ProblematicWordDbReader;
import com.jarman.extract.data.ProblematicWordReader;
import com.jarman.pojos.ProblematicWord;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProblematicWordsDbReaderTest {

    @Test
    public void testReaderReturnsAllWordsFromDb() {
        ProblematicWordReader problematicWordReader = new ProblematicWordDbReader();
        List<ProblematicWord> problematicWordList = problematicWordReader.getAllProblematicWords();
        ProblematicWord problematicWord = problematicWordList.get(0);
        assertEquals(problematicWord.getOriginalWord(), "blacklist");
        assertEquals(problematicWordList.size(), 2);
    }

}
