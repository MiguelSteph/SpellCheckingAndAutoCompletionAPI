package com.spell.entities;

import java.util.List;

/**
 * @author Stephane Miguel KAKANAKOU (Skakanakou@gmail.com)
 */
public class AutoCompletion {

    private final String prefix;
    
    private List<String> propositions;
    
    public AutoCompletion(String prefix) {
        this.prefix = prefix;
    }

    public List<String> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<String> propositions) {
        this.propositions = propositions;
    }

    public String getPrefix() {
        return prefix;
    }
    
}
