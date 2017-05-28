package com.spell.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the implementation of 26 way Trie. This data structure is
 * very efficient for spell checking.
 * 
 * @author Stephane Miguel KAKANAKOU (Skakanakou@gmail.com)
 */
public class RWayTrie implements IRWayTrie {

    private static final int R = 26;

    /* Private class that represent a node in the trie. */
    private class Node {
        boolean isWord;
        Node[] next = new Node[R];
    }

    /*** Root node of the trie */
    private Node root;

    /** Constructor of the Trie. */
    public RWayTrie() {
        root = new Node();
    }

    /*** {@inheritDoc} */
    @Override
    public void put(String word) {
        root = put(root, word, 0);
    }

    private Node put(Node x, String key, int d) {
        if (x == null)
            x = new Node();
        if (d == key.length()) {
            x.isWord = true;
            return x;
        }
        int c = key.charAt(d);
        c = c - 97;
        x.next[c] = put(x.next[c], key, d + 1);
        return x;
    }

    /*** {@inheritDoc} */
    @Override
    public boolean containsWord(String word) {
        Node x = get(root, word, 0);
        if ((x == null) || (!x.isWord))
            return false;
        return true;
    }

    private Node get(Node x, String key, int d) {
        if (x == null)
            return null;
        if (d == key.length())
            return x;
        int c = key.charAt(d);
        c = c - 97;
        return get(x.next[c], key, d + 1);
    }

    /*** {@inheritDoc} */
    @Override
    public List<String> wordsWithPrefix(String prefix, int listSize) {
        List<String> list = new ArrayList<>();
        Node x = get(root, prefix, 0);
        collect(x, prefix, list, listSize);
        return list;
    }

    /*** {@inheritDoc} */
    @Override
    public String longestPrefixOf(String s) {
        int length = longestPrefixOf(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int longestPrefixOf(Node x, String s, int length, int d) {
        if (x == null)
            return length;
        if (x.isWord)
            length = d;
        if (d == s.length())
            return d;
        int c = s.charAt(d);
        return longestPrefixOf(x.next[c], s, length, d + 1);
    }

    private void collect(Node x, String prefix, List<String> list, int listSize) {
        if (x == null)
            return;
        if (x.isWord)
            list.add(prefix);
        if (list.size() == listSize)
            return;
        for (char c = 97; c < R + 97; c++) {
            collect(x.next[c - 97], prefix + c, list, listSize);
        }
    }

}
