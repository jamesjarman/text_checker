package com.jarman.extract.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class WordExtractor implements Extractor{

    private final String file;

    public WordExtractor(String file) {
        this.file = file;
    }

    @Override
    public List<String> getAllWords() {
        List<String> words = Collections.emptyList();
        String content = null;
        try {
            content = new Scanner(new File(file)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException f) {
            System.out.println("The file was not found");
        } catch (NoSuchElementException n) {
            System.out.println("The file is empty");
        } catch (Exception e) {
            System.out.println("There was exception" + e);
        }
        if (content != null) {
            words = Arrays.asList(content.split(" "));
        }
        return words;
    }
}
