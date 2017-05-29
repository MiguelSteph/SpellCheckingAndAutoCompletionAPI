package com.spell.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.spell.dao.IRWayTrie;
import com.spell.dao.RWayTrie;
import com.spell.entities.AutoCompletion;
import com.spell.entities.LongestPrefixWord;
import com.spell.entities.SpellingCheck;

/**
 * @author Stephane Miguel KAKANAKOU (Skakanakou@gmail.com)
 */
public class Service {

    private static final Service service = new Service();
    
    private static final int SUGGESTION_SIZE = 10;
    private static final int PROPOSITION_SIZE = 10;

    private IRWayTrie trie;

    private Service() {
        trie = new RWayTrie();
        loadWords();
    }

    public static Service getInstance() {
        return service;
    }
    
    public LongestPrefixWord longestPrefixWord(String query) {
        LongestPrefixWord lgPrefix = new LongestPrefixWord(query);
        lgPrefix.setLongestPrefixWord(trie.longestPrefixOf(query));
        return lgPrefix;
    }
    
    public AutoCompletion autoCompletion(String prefix) {
        AutoCompletion completion = new AutoCompletion(prefix);
        completion.setPropositions(trie.wordsWithPrefix(prefix, PROPOSITION_SIZE));
        return completion;
    }
    
    public SpellingCheck spellingCheck(String query) {
        SpellingCheck check = new SpellingCheck(query);
        check.setWellSpelled(trie.containsWord(query));
        if (!check.isWellSpelled()) {
            String rightPrefix = trie.longestPrefixOf(query);
            check.setSuggestion(trie.wordsWithPrefix(rightPrefix, SUGGESTION_SIZE));
        }
        return check;
    }
    
    private void loadWords() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("words_alpha.txt").getFile());

        System.out.println(file.getAbsolutePath());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if ((line != null) && (!line.isEmpty())) {
                    trie.put(line);
                }
            }

        } catch (IOException e) {

        }
    }

    public String formalisationString(String query) {
        if (query == null)
            return null;
        query = query.toLowerCase();
        StringBuilder str = new StringBuilder();
        int c;
        for (int i = 0; i < query.length(); i++) {
            c = query.charAt(i);
            if ((c >= 97) && (c <= 122)) {
                str.append(c);
            } else {
                return null;
            }
        }
        return str.toString();
    }

}
