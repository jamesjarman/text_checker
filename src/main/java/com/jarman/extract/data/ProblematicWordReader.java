package com.jarman.extract.data;

import com.jarman.pojos.ProblematicWord;

import java.util.List;

public interface ProblematicWordReader {
    List<ProblematicWord> getAllProblematicWords(String file);

}
