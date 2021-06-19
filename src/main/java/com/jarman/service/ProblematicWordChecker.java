package com.jarman.service;

import com.jarman.pojos.ProblematicWord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class ProblematicWordChecker {


    public static List<ProblematicWord> checker(List<String> words, List<ProblematicWord> problematicWords) {
        List<ProblematicWord> suggestionsList = new ArrayList<>();
        for (String word : words) {
            for (ProblematicWord problematicWord : problematicWords) {
                if (problematicWord.getOriginalWord().equalsIgnoreCase(word)) {
                    suggestionsList.add(problematicWord);
                }
            }
                   }

        return suggestionsList;
    }

}
