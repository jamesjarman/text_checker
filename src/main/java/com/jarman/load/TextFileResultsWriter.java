package com.jarman.load;

import java.io.FileWriter;
import java.io.IOException;

import static com.jarman.FilePathConstants.RESULTS_FILE;

public class TextFileResultsWriter {


    private String results;
    private String fileName;

    public TextFileResultsWriter(String results, String fileName) {
        this.results = results;
        this.fileName = fileName;
    }


    public void writeResultsToFile() {
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(RESULTS_FILE);
            // TODO add the date to the filename?

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert myWriter != null;
                myWriter.write(results);

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
