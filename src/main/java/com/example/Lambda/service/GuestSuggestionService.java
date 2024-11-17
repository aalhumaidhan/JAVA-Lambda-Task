package com.example.Lambda.service;

import com.example.Lambda.entity.GuestSuggestionEntity;
import com.example.Lambda.repository.GuestSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestSuggestionService {

    @Autowired
    private GuestSuggestionRepository guestSuggestionRepository;

    public GuestSuggestionService(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    SuggestionProcessor processSuggestion = (suggestionText, rate) -> {
        GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
        suggestionEntity.setRate(rate);
        suggestionEntity.setSuggestionText(suggestionText);
        guestSuggestionRepository.save(suggestionEntity);
    };

    public String printAndProcessSuggestion(String text, int rate) {
        processSuggestion.process(text, rate);
        return "Successful";
    }


}
