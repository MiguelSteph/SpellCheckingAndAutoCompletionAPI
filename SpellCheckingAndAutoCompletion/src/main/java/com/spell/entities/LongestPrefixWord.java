package com.spell.entities;

/**
 * @author Stephane Miguel KAKANAKOU (Skakanakou@gmail.com)
 */
public class LongestPrefixWord {

    private final String queryString;
    
    private String longestPrefixWord;

    public LongestPrefixWord(String query) {
        this.queryString = query;
    }
    
    public String getLongestPrefixWord() {
        return longestPrefixWord;
    }

    public void setLongestPrefixWord(String longestPrefixWord) {
        this.longestPrefixWord = longestPrefixWord;
    }

    public String getQueryString() {
        return queryString;
    }
    
}
