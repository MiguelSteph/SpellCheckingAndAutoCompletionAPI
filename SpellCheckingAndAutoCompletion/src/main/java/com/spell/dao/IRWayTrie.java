package com.spell.dao;

import java.util.List;

/**
 * 
 * @author Stephane Miguel KAKANAKOU (Skakanakou@gmail.com)
 *
 */
public interface IRWayTrie {

    /**
     * Insert a word in the trie. We assume that the word only contains english
     * characters.
     * 
     * @param word
     *            the word we want to insert.
     */
    public void put(String word);

    /**
     * check is a specific word is in the trie.
     * 
     * @param word
     *            the word we want to check
     * @return true if the word is in the trie and false if not.
     */
    public boolean containsWord(String word);

    /**
     * return a list of word that begin with a specific prefix. We limit the
     * size of the list at 100 words.
     * 
     * @param prefix
     * @return the list of word that have the given string as prefix.
     */
    public List<String> wordsWithPrefix(String prefix, int listSize);

    /**
     * return a word that is the longest prefix of the given word.
     * 
     * @param s
     * @return return a word that is the longest prefix of the given word.
     */
    public String longestPrefixOf(String s);

}

