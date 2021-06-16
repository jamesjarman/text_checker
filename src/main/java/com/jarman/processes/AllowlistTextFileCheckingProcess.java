package com.jarman.processes;

import com.jarman.extract.data.ProblematicWordReader;
import com.jarman.extract.text.Extractor;
import com.jarman.extract.text.WordExtractor;
import com.jarman.load.TextFileResultsWriter;
import com.jarman.pojos.ProblematicWord;

import java.util.List;

import static com.jarman.FilePathConstants.ALLOWLIST;
import static com.jarman.service.ProblematicWordChecker.checker;

public class AllowlistTextFileCheckingProcess {

    public Extractor wordExtractor;
    public ProblematicWordReader problematicWordReader;
    public String resultsFilename;

    public AllowlistTextFileCheckingProcess(Extractor t, ProblematicWordReader c, String r) {
        this.problematicWordReader = c;
        this.wordExtractor = t;
        this.resultsFilename = r;
    }

    public void runProcess() {

        List<String> wordsFromArticle = wordExtractor.getAllWords();

        List<ProblematicWord> allProblematicWords = problematicWordReader.getAllProblematicWords(ALLOWLIST);
        List<ProblematicWord> problematicWordsFound = checker(wordsFromArticle, allProblematicWords);

        TextFileResultsWriter textFileResultsWriter = new TextFileResultsWriter(problematicWordsFound, resultsFilename);
        textFileResultsWriter.writeResultsToFile();
    }
}