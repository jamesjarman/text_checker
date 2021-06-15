package com.jarman.pojos;

import java.util.Objects;

public class ProblematicWord {
    private String originalWord;
    private String alternativeWord;
    private String explanation;

    public ProblematicWord(String originalWord, String alternativeWord, String explanation) {
        this.alternativeWord = alternativeWord;
        this.originalWord = originalWord;
        this.explanation = explanation;
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord;
    }

    public String getAlternativeWord() {
        return alternativeWord;
    }

    public void setAlternativeWord(String alternativeWord) {
        this.alternativeWord = alternativeWord;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "ReplacementWord{" +
                "originalWord='" + originalWord + '\'' +
                ", alternativeWord='" + alternativeWord + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProblematicWord that = (ProblematicWord) o;
        return Objects.equals(originalWord, that.originalWord) &&
                Objects.equals(alternativeWord, that.alternativeWord) &&
                Objects.equals(explanation, that.explanation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalWord, alternativeWord, explanation);
    }
}
