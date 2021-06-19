package com.jarman.extract.data;

import com.jarman.pojos.ProblematicWord;

import java.util.Collections;
import java.util.List;

public interface ProblematicWordReader {

    default List<ProblematicWord> getAllProblematicWords(String file) {
        return Collections.emptyList();
    }

    default List<ProblematicWord> getAllProblematicWords() {
        return Collections.emptyList();
    }


}
