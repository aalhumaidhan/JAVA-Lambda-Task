package com.example.Lambda.controller;

import com.example.Lambda.bo.CreateSuggestionRequest;
import com.example.Lambda.entity.GuestSuggestionEntity;
import com.example.Lambda.service.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SuggestionController {

    @Autowired
    private GuestSuggestionService suggestionService;

    @PostMapping("/suggestions")
    public ResponseEntity<String> processSuggestion(@RequestBody CreateSuggestionRequest request) {
        String response = suggestionService.printAndProcessSuggestion(request.getSuggestionText(), request.getRate());
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
