package com.uditha;

import com.uditha.solution.Palindrome;
import com.uditha.solution.PalindromeSolution;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestPalindrome {
    @Test
    public void validateThreeMostLargestPalindromeStringsInGivenString() {
        List<Palindrome> palindromes = PalindromeSolution.findPalindromes("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop");

        //Check palindrome
        Assert.assertEquals(palindromes.get(0).getPalindrome(), "hijkllkjih");
        Assert.assertEquals(palindromes.get(1).getPalindrome(), "defggfed");
        Assert.assertEquals(palindromes.get(2).getPalindrome(), "abccba");

        //Check index
        Assert.assertEquals(palindromes.get(0).getIndex(), 23);
        Assert.assertEquals(palindromes.get(1).getIndex(), 13);
        Assert.assertEquals(palindromes.get(2).getIndex(), 5);
    }

    @Test
    public void validateTheEntireInputStringIsReturnedAsAPalindrome() {
        List<Palindrome> palindromes = PalindromeSolution.findPalindromes("aaaabbabbaaaa");

        //Check the list size
        Assert.assertEquals(palindromes.size(), 1);

        //Check palindrome
        Assert.assertEquals(palindromes.get(0).getPalindrome(), "aaaabbabbaaaa");

        //Check index
        Assert.assertEquals(palindromes.get(0).getIndex(), 0);
    }

    @Test
    public void validateEmptyReturnListForZeroLengthInputString() {
        List<Palindrome> palindromes = PalindromeSolution.findPalindromes("");

        //Check the list size
        Assert.assertEquals(palindromes.size(), 0);
    }

    @Test
    public void validateThrownExceptionForNullInputString() {
        List<Palindrome> palindromes = PalindromeSolution.findPalindromes(null);

        //Check the list size
        Assert.assertEquals(palindromes.size(), 0);
    }

    @Test
    public void validateTwoSeperatePalindromeStringsAndTheirIndex() {
        List<Palindrome> palindromes = PalindromeSolution.findPalindromes("aahaabbbybbb");

        //Check palindrome
        Assert.assertEquals(palindromes.get(0).getPalindrome(), "bbbybbb");
        Assert.assertEquals(palindromes.get(1).getPalindrome(), "aahaa");


        //Check index
        Assert.assertEquals(palindromes.get(0).getIndex(), 5);
        Assert.assertEquals(palindromes.get(1).getIndex(), 0);
    }

    @Test
    public void validateSingleCharacterPalindrome() {
        List<Palindrome> palindromes = PalindromeSolution.findPalindromes("a");

        //Check palindrome
        Assert.assertEquals(palindromes.get(0).getPalindrome(), "a");

        //Check index
        Assert.assertEquals(palindromes.get(0).getIndex(), 0);
    }

    @Test
    public void validateTwoIndividualCharacterPalindromesAndTheirIndicesOrder() {
        List<Palindrome> palindromes = PalindromeSolution.findPalindromes("ab");

        //Check palindrome
        Assert.assertEquals(palindromes.get(0).getPalindrome(), "b");
        Assert.assertEquals(palindromes.get(1).getPalindrome(), "a");

        //Check index
        Assert.assertEquals(palindromes.get(0).getIndex(), 1);
        Assert.assertEquals(palindromes.get(1).getIndex(), 0);
    }
}
