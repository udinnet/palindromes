package com.uditha;

import com.uditha.solution.Palindrome;
import com.uditha.solution.PalindromeSolution;

import java.text.MessageFormat;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        String input = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop";
        int outputCount = 3;

        if (args.length == 2) {
            input = args[0];
            outputCount = Integer.parseInt(args[1]);
        }

        List<Palindrome> palindromes = PalindromeSolution.findPalindromes(input);

        for (int i = 0; i < outputCount; i++) {
            System.out.println(MessageFormat.format("Text: {0}, Index: {1}, Length: {2}"
                    , palindromes.get(i).getPalindrome()
                    , palindromes.get(i).getIndex()
                    , palindromes.get(i).getLength()
                    )
            );
        }
    }
}
