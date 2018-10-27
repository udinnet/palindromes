package com.uditha.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PalindromeSolution {
    /**
     * Limits the levels of recursion. Can be set in pom.xml files recursion.depth.value property or in command line
     * Allowed only positive integer values. Default values is 2.
     */
    private static final int MAX_RECURSION_DEPTH = Integer.valueOf(System.getProperty("recursion.depth", "2"));

    /**
     * Finds the unique palindromes in a recursive fashion using Manacher’s algorithm
     *
     * @param string Input composite string with all the palindromes
     * @return A sorted {@link List} of palindromes in descending order of length
     */
    public static List<Palindrome> findPalindromes(final String string) {
        return string != null ? findPalindromes(string, 0, 0) : new ArrayList<>();
    }

    /**
     * Finds the unique palindromes in a recursive fashion using Manacher’s algorithm
     *
     * @param string         Input composite string with all the palindromes
     * @param offset         Carries the absolute offset index of the original source string through the recursion
     * @param recursionDepth A maximum depth for the recursion through sub-strings to find palindromes
     * @return A sorted {@link List} of palindromes in descending order of length
     */
    private static List<Palindrome> findPalindromes(final String string, final int offset, final int recursionDepth) {
        final char[] stringWithBoundaries = addBoundaries(string);
        final int boundaryStringLength = stringWithBoundaries.length;
        int center = 0, right = 0;

        final int[] palindromeSpan = new int[boundaryStringLength];

        //Applying Manacher’s algorithm
        for (int i = 1; i < boundaryStringLength - 1; i++) {
            int mirrorIndex = 2 * center - i;

            palindromeSpan[i] = right > i ? Math.min(right - i, stringWithBoundaries[mirrorIndex]) : 0;

            while (stringWithBoundaries[i + 1 + palindromeSpan[i]] == stringWithBoundaries[i - 1 - palindromeSpan[i]]) {
                palindromeSpan[i]++;
            }

            if (i + palindromeSpan[i] > right) {
                center = i;
                right = i + palindromeSpan[i];
            }
        }

        int maxLength = 0;
        int centerIndex = 0;

        for (int i = 1; i < boundaryStringLength - 1; i++) {
            if (palindromeSpan[i] > maxLength) {
                maxLength = palindromeSpan[i];
                centerIndex = i;
            }
        }

        char[] extracted = Arrays.copyOfRange(stringWithBoundaries, centerIndex - maxLength, centerIndex + maxLength + 1);
        String palindrome = new String(removeBoundaries(extracted));
        int palindromeIndex = string.indexOf(palindrome);
        List<Palindrome> palindromes = new ArrayList<>(5);

        if ((MAX_RECURSION_DEPTH == 0 || recursionDepth < MAX_RECURSION_DEPTH) && string.length() > 1) {
            // left side of the string
            palindromes.addAll(findPalindromes(string.substring(0, palindromeIndex), offset, recursionDepth + 1));

            // right side of the string
            palindromes.addAll(findPalindromes(string.substring(palindromeIndex + palindrome.length())
                    , offset + palindromeIndex + palindrome.length(), recursionDepth + 1));
        }

        if (palindrome.length() > 0) {
            palindromes.add(new Palindrome(palindrome, palindromeIndex + offset));
        }

        //Sorting the list of palindromes in descending order of length
        palindromes.sort(Comparator.reverseOrder());

        return palindromes;
    }

    private static char[] addBoundaries(String originalString) {
        if (originalString == null || originalString.length() == 0)
            return "^$".toCharArray();

        char[] chars = originalString.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append("^");

        for (int i = 0; i < originalString.length(); i++) {
            sb.append("#").append(chars[i]);
        }

        sb.append("#$");
        return sb.toString().toCharArray();
    }

    private static char[] removeBoundaries(char[] characters) {
        if (characters == null || characters.length < 3)
            return "".toCharArray();

        char[] returningArray = new char[(characters.length - 1) / 2];
        for (int i = 0; i < returningArray.length; i++) {
            returningArray[i] = characters[i * 2 + 1];
        }
        return returningArray;
    }
}
