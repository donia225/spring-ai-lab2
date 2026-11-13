package com.example.ai.model;

import jakarta.validation.constraints.NotBlank;

public class ExplainRequest {

@NotBlank 
public String concept;


public String level;


public String getConcept() {
        return concept;
    }
public void setConcept(String concept) {
        this.concept = concept;
    }
public String getLevel() {
        return level;
    }
public void setLevel(String level) {
        this.level = level;
    }


}
