package com.jarman.processes;

import com.jarman.extract.data.ProblematicWordReader;
import com.jarman.extract.text.Extractor;
import com.jarman.load.TextFileResultsWriter;
import com.jarman.pojos.ProblematicWord;
import com.jarman.service.ResultsCreator;

import java.util.List;

import static com.jarman.FilePathConstants.ALLOWLIST;
import static com.jarman.service.ProblematicWordChecker.checker;

public class AllowlistTextFileCheckingProcess {

    public Extractor wordExtractor;
    public ProblematicWordReader problematicWordReader;
    public String resultsFile;

    public AllowlistTextFileCheckingProcess(Extractor extractor, ProblematicWordReader problematicWordReader, String resultsFile) {
        this.problematicWordReader = problematicWordReader;
        this.wordExtractor = extractor;
        this.resultsFile = resultsFile;
    }

    public void runProcessWithCsv() {

        List<String> wordsFromArticle = wordExtractor.getAllWords();

        List<ProblematicWord> allProblematicWords = problematicWordReader.getAllProblematicWords(ALLOWLIST);
        List<ProblematicWord> problematicWordsFound = checker(wordsFromArticle, allProblematicWords);
        String results = new ResultsCreator(problematicWordsFound).getResults();
        TextFileResultsWriter textFileResultsWriter = new TextFileResultsWriter(results, resultsFile);
        textFileResultsWriter.writeResultsToFile();
    }

    public void runProcessWithDb() {

        List<String> wordsFromArticle = wordExtractor.getAllWords();

        List<ProblematicWord> allProblematicWords = problematicWordReader.getAllProblematicWords();
        List<ProblematicWord> problematicWordsFound = checker(wordsFromArticle, allProblematicWords);
        String results = new ResultsCreator(problematicWordsFound).getResults();
        TextFileResultsWriter textFileResultsWriter = new TextFileResultsWriter(results, resultsFile);
        textFileResultsWriter.writeResultsToFile();
    }

}