package com.jarman.service;

import com.jarman.pojos.ProblematicWord;

import java.util.ArrayList;
import java.util.List;

public final class ProblematicWordChecker {


    public static List<ProblematicWord> checker(List<String> words, List<ProblematicWord> problematicWords) {
        List<ProblematicWord> suggestionsList = new ArrayList<>();
        for (String word : words) {
            for (ProblematicWord problematicWord : problematicWords) {
                if (problematicWord.getOriginalWord().equals(word)) {
                    suggestionsList.add(problematicWord);
                }
            }

        } return suggestionsList;
    }

}
