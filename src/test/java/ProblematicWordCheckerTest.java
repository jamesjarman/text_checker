import com.jarman.pojos.ProblematicWord;
import static com.jarman.service.ProblematicWordChecker.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ProblematicWordCheckerTest {

    public static final String BLACKLIST = "blacklist";
    public static final String ALLOWLIST = "allowlist";
    public static final String EXPLANATION = "The word \"blacklist\" equates blackness with badness";
    public static final String SLAVE = "slave";
    public static final String SECONDARY = "secondary";
    public static final String EXPLANATION2 = "In a technical context you may want to consider alternatives to master/slave";
    public static final String INNOCENT_WORD = "innocent_word";


    @Test
    public void testThatTheCheckerIdentifiesProblematicWords() {
        List<String> words = new ArrayList<>();
        words.add(BLACKLIST);
        List<ProblematicWord> problematicWords = new ArrayList<>();
        ProblematicWord problematicWord = new ProblematicWord(BLACKLIST, ALLOWLIST, EXPLANATION);

        problematicWords.add(problematicWord);
        assertEquals(checker(words, problematicWords).size(), 1);
    }

    @Test
    public void testThatTheCheckerDoesNotFalslyIdentifyNonProblematicWords() {
        List<String> words = new ArrayList<>();
        words.add(INNOCENT_WORD);

        List<ProblematicWord> problematicWords = new ArrayList<>();
        ProblematicWord problematicWord = new ProblematicWord(BLACKLIST, ALLOWLIST, EXPLANATION);

        problematicWords.add(problematicWord);
        assertEquals(checker(words, problematicWords).size(), 0);
    }

    @Test
    public void testThatTheCheckerFindsMultipleProblematicWords() {
        List<String> words = new ArrayList<>();
        words.add(BLACKLIST);
        words.add(SLAVE);
        List<ProblematicWord> problematicWords = new ArrayList<>();
        ProblematicWord problematicWord1 = new ProblematicWord(BLACKLIST, ALLOWLIST, EXPLANATION);
        ProblematicWord problematicWord2 = new ProblematicWord(SLAVE, SECONDARY, EXPLANATION2);
        problematicWords.add(problematicWord1);
        problematicWords.add(problematicWord2);
        assertEquals(checker(words, problematicWords).size(), 2);
    }


    @Test
    public void testThatTheCheckerIsNotCaseSensitive() {
        List<String> words = new ArrayList<>();
        words.add("BLACKLIST");
        List<ProblematicWord> problematicWords = new ArrayList<>();
        ProblematicWord problematicWord = new ProblematicWord(BLACKLIST, ALLOWLIST, EXPLANATION);

        problematicWords.add(problematicWord);
        assertEquals(checker(words, problematicWords).size(), 1);
    }


    @Test
    public void testThatTheCheckerHandlesEmptyInput() {
        List<String> words = new ArrayList<>();
        List<ProblematicWord> problematicWords = new ArrayList<>();
        ProblematicWord problematicWord = new ProblematicWord(BLACKLIST, ALLOWLIST, EXPLANATION);
        problematicWords.add(problematicWord);
        assertEquals(checker(words, problematicWords).size(), 0);
    }

    @Test
    public void testThatTheCheckerHandlesMissingProblematicWordData() {
        List<String> words = new ArrayList<>();
        words.add(BLACKLIST);
        List<ProblematicWord> problematicWords = new ArrayList<>();
        assertEquals(checker(words, problematicWords).size(), 0);
    }



}