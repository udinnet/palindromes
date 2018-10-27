package com.uditha.solution;

import org.jetbrains.annotations.NotNull;

/**
 * This class holds an instance of valid palindrome which is extracted from another string
 *
 * @author Uditha Wijerathna
 */
public class Palindrome implements Comparable<Palindrome> {
    private String palindrome;
    private int index;

    /**
     * Construct a palindrome instance using the actual palindrome string and the original index
     * of that string in the composite source string
     *
     * @param palindrome The palindrome string
     * @param index      Index of the palindrome string within the original string
     */
    Palindrome(@NotNull String palindrome, int index) {
        this.palindrome = palindrome;
        this.index = index;
    }

    /**
     * @return The palindrome string
     */
    public String getPalindrome() {
        return palindrome;
    }

    /**
     * @return Index of the palindrome string within the original string
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return The length of the palindrome string
     */
    public int getLength() {
        return palindrome.length();
    }

    /**
     * Compares a {@link Palindrome} object with another object using the length of
     * palindrome string
     *
     * @param source Source object to compare
     * @return the comparator value, negative if less, positive if greater
     */
    @Override
    public int compareTo(@NotNull Palindrome source) {
        final int lengthCompare = Integer.compare(getLength(), source.getLength());
        return lengthCompare == 0 ? palindrome.compareTo(source.palindrome) : lengthCompare;
    }
}
