package com.jarman.load;

import java.io.FileWriter;
import java.io.IOException;

public class TextFileResultsWriter {


    private final String results;
    private final String fileName;

    public TextFileResultsWriter(String results, String fileName) {
        this.results = results;
        this.fileName = fileName;
    }


    public void writeResultsToFile() {
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(fileName);
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
