package com.example.ai.service;

import org.springframework.stereotype.Service;

import com.example.ai.enums.PromptTemplates;

@Service
public class PromptTemplateService {
        public String buildExplainPrompt(String concept, String level) {
        return String.format(PromptTemplates.EXPLAIN_CONCEPT, concept, level);
    }
    
    public String buildCodePrompt(String task, String constraints) {
        return String.format(PromptTemplates.GENERATE_CODE, task, constraints);
    }

}
