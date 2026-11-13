package com.example.ai.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ai.model.ExplainRequest;
import com.example.ai.model.QcmRequest;
import com.example.ai.service.PromptService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ai")
public class AiController {
    private final PromptService promptService;

public AiController(PromptService promptService) {
        this.promptService = promptService;
    }
@PostMapping("/explain")
public String explainConcept(@Valid @RequestBody ExplainRequest request) {

     return promptService.explainConcept(request.getConcept(), request.getLevel());
    }

@PostMapping("/explain-structured")
public String explainConceptStructured(@Valid @RequestBody ExplainRequest request) {

     return promptService.explainConceptStructured(request.getConcept(), request.getLevel());
    }

@PostMapping ("/qcm")
public String zeroShotExplain(@Valid @RequestBody QcmRequest request){
    return promptService.zeroShotExplain(request.getQcm());

}

@PostMapping ("/fewshots")
public String fewShot(@Valid @RequestBody ExplainRequest request){
    return promptService.fewShotExplain(request.getConcept());
}

@PostMapping ("/explainWithLangage&Markdown")
public String explainWithLangageAndMarkdown(@Valid @RequestBody ExplainRequest request){
  return promptService.explainWithLanguageAndMarkdown(request.getConcept());
}
}
