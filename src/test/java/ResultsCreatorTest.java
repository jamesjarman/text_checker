import com.jarman.pojos.ProblematicWord;
import com.jarman.service.ResultsCreator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultsCreatorTest {

    @Test
    public void testResultsAreGeneratedWhenThereAreNoProblematicWords(){
        List<ProblematicWord> problematicWords = new ArrayList<>();
        ResultsCreator resultsCreator = new ResultsCreator(problematicWords);
        String actualResults = resultsCreator.getResults();
        String expectedResults = "There were no problematic words in your text.";
        assertEquals(actualResults,expectedResults);
    }


    @Test
    public void testResultsAreGeneratedWhenThereIsOneProblematicWord(){
        List<ProblematicWord> problematicWords = new ArrayList<>();
        ProblematicWord problematicWord = new ProblematicWord("blacklist", "denylist", "you may want to avoid associating black/white with bad/good.");
        problematicWords.add(problematicWord);

        ResultsCreator resultsCreator = new ResultsCreator(problematicWords);
        String actualResults = resultsCreator.getResults();
        String expectedResults = "There was 1 potentially problematic word in your text. You may want to consider replacing blacklist with denylist because you may want to avoid associating black/white with bad/good.";
        assertEquals(actualResults,expectedResults);
    }

    @Test
    public void testResultsAreGeneratedWhenThereAreMultipleProblematicWords() {
        List<ProblematicWord> problematicWords = new ArrayList<>();
        ProblematicWord problematicWord1 = new ProblematicWord("blacklist", "denylist", "you may want to avoid associating black/white with bad/good.");
        ProblematicWord problematicWord2 = new ProblematicWord("whitelist", "allowlist", "you may want to avoid associating black/white with bad/good.");
        problematicWords.add(problematicWord1);
        problematicWords.add(problematicWord2);


        ResultsCreator resultsCreator = new ResultsCreator(problematicWords);
        String actualResults = resultsCreator.getResults();
        String expectedResults = "There were 2 potentially problematic words in your text. You may want to consider replacing" +
                " blacklist with denylist because you may want to avoid associating black/white with bad/good.You may want to consider replacing" +
                " whitelist with allowlist because you may want to avoid associating black/white with bad/good.";
        assertEquals(expectedResults, actualResults);
    }


        @Test
        public void testResultsAreGeneratedCorrectlyWhenThereAreMultipleInstancesOfProblematicWords(){
            List<ProblematicWord> problematicWords = new ArrayList<>();
            ProblematicWord problematicWord1 = new ProblematicWord("blacklist", "denylist", "you may want to avoid associating black/white with bad/good.");
            ProblematicWord problematicWord2 = new ProblematicWord("blacklist", "denylist", "you may want to avoid associating black/white with bad/good.");
            problematicWords.add(problematicWord1);
            problematicWords.add(problematicWord2);


            ResultsCreator resultsCreator = new ResultsCreator(problematicWords);
            String actualResults = resultsCreator.getResults();
            String expectedResults = "There was 1 potentially problematic word in your text. You may want to consider replacing" +
                    " blacklist with denylist because you may want to avoid associating black/white with bad/good.";
            assertEquals(expectedResults,actualResults);

    }


}
