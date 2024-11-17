package com.example.Lambda.service;

@FunctionalInterface
public interface SuggestionProcessor {
    void process(String suggestionText, int rate);
}
