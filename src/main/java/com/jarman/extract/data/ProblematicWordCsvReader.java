package com.jarman.extract.data;

import com.jarman.pojos.ProblematicWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.jarman.FilePathConstants.ALLOWLIST;

public class ProblematicWordCsvReader implements ProblematicWordReader {

    @Override
    public List<ProblematicWord> getAllProblematicWords(String file) {
        List<ProblematicWord> problematicWords = new ArrayList<>();
        Path pathToFile = Paths.get(file);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                ProblematicWord problematicWord = createCorrection(attributes);
                problematicWords.add(problematicWord);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("There was an issue getting the problematic words from the csv file");
            ioe.printStackTrace();
        }
        return problematicWords;
    }

    public static ProblematicWord createCorrection(String[] metadata) {
        String word = metadata[0];
        String replacement = metadata[1];
        String reason = metadata[2];
        return new ProblematicWord(word, replacement, reason);
    }

}
