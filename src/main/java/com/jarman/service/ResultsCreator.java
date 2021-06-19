package com.jarman.service;

import com.jarman.pojos.ProblematicWord;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsCreator {
    private static int totalProblematicWords;

    private List<ProblematicWord> suggestionsList;


    public ResultsCreator(List<ProblematicWord> suggestionsList) {
        totalProblematicWords = suggestionsList.size();
        this.suggestionsList = suggestionsList.stream()
                .distinct()
                .collect(Collectors.toList());
        ;
    }


    public String getResults() {
        String results = "There were no problematic words in your text.";
        if (suggestionsList.size() >= 1) {

            results = getResponseBasedOnNumberOfProblematicWords();
            for (ProblematicWord problematicWord : suggestionsList) {

                results = results + getSuggestion(problematicWord);
            }
        }
        return results;
    }

    private String getSuggestion(ProblematicWord problematicWord) {
        return "You may want to consider replacing " + problematicWord.getOriginalWord()
                + " with " + problematicWord.getAlternativeWord()
                + " because " + problematicWord.getExplanation();
    }

    private String getResponseBasedOnNumberOfProblematicWords() {
        String response = "There was 1 potentially problematic word in your text. ";
        if (totalProblematicWords > 1) {
            response = "There were " + totalProblematicWords + " potentially problematic words in your text. ";
        }
        return response;
    }

}
