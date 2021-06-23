package com.jarman.service;

import com.jarman.pojos.ProblematicWord;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsCreator {

    private final List<ProblematicWord> suggestionsList;


    public ResultsCreator(List<ProblematicWord> suggestionsList) {
        this.suggestionsList = suggestionsList.stream()
                .distinct()
                .collect(Collectors.toList());
    }


    public String getResults() {
        var results = new StringBuilder();
        results.append(getResponseBasedOnNumberOfProblematicWords());
               for (ProblematicWord problematicWord : suggestionsList) {
                results.append(getSuggestion(problematicWord));
            }
        return String.valueOf(results);
    }

    private String getSuggestion(ProblematicWord problematicWord) {
        return "You may want to consider replacing " + problematicWord.getOriginalWord()
                + " with " + problematicWord.getAlternativeWord()
                + " because " + problematicWord.getExplanation();
    }

    private String getResponseBasedOnNumberOfProblematicWords() {
        var response = "There were no problematic words in your text.";
        var totalProblematicWords = suggestionsList.size();
        if (totalProblematicWords == 1) {
            response = "There was 1 potentially problematic word in your text. ";
        } else if (totalProblematicWords>1) {
            response = String.format("There were %s potentially problematic words in your text. ", totalProblematicWords);
        }
        return response;
    }

}
