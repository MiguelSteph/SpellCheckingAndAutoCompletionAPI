package com.spell.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stephane Miguel KAKANAKOU (Skakanakou@gmail.com)
 */
public class SpellingCheck {

    private final String queryString;
    
    private boolean isWellSpelled;
    
    private List<String> suggestion;
    
    public SpellingCheck(String query) {
        this.queryString = query;
        suggestion = new ArrayList<>();
    }

    public boolean isWellSpelled() {
        return isWellSpelled;
    }

    public void setWellSpelled(boolean isWellSpelled) {
        this.isWellSpelled = isWellSpelled;
    }

    public List<String> getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(List<String> suggestion) {
        this.suggestion = suggestion;
    }

    public String getQueryString() {
        return queryString;
    }
    
}
