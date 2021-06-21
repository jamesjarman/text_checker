package com.jarman.service;

import com.jarman.extract.data.ProblematicWordDbReader;
import com.jarman.extract.data.ProblematicWordReader;
import com.jarman.extract.text.Extractor;
import com.jarman.extract.text.WordExtractor;
import com.jarman.processes.AllowlistTextFileCheckingProcess;

import static com.jarman.FilePathConstants.RESULTS_FILE_2;

public class AllowlistTextFileCheckingRunner {

    public static void checkFileForProblematicWords(String filePath) {
        Extractor extractor = new WordExtractor(filePath);
        ProblematicWordReader problematicWordReader = new ProblematicWordDbReader();

        AllowlistTextFileCheckingProcess allowlistTextFileCheckingProcess = new AllowlistTextFileCheckingProcess(extractor, problematicWordReader, RESULTS_FILE_2);
        allowlistTextFileCheckingProcess.runProcessWithDb();
    }
}
