package com.jarman;

import static com.jarman.service.AllowlistTextFileCheckingRunner.checkFileForProblematicWords;

public class Main {
    public static void main(String[] args) {

        if (args.length>0) {
            checkFileForProblematicWords(args[0]);
        } else {
            System.out.println("No arguments provided");
        }
    }
}
