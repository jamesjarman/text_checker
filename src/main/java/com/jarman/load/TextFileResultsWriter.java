package com.jarman.load;

import com.jarman.pojos.ProblematicWord;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.jarman.FilePathConstants.RESULTS;

public class TextFileResultsWriter {


    private List<ProblematicWord> problematicWords;
    private String fileName;

    public TextFileResultsWriter(List<ProblematicWord> problematicWords, String fileName) {
        this.problematicWords = problematicWords;
        this.fileName = fileName;
    }


    public void writeResultsToFile() {
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(RESULTS);
            // TODO add the date to the filename?

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert myWriter != null;
            for (ProblematicWord problematicWord : problematicWords) {
                myWriter.write("You may want to consider replacing " + problematicWord.getOriginalWord() + " with " + problematicWord.getAlternativeWord() + " because " + problematicWord.getExplanation());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
