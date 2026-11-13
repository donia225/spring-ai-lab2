package com.example.ai.model;
import jakarta.validation.constraints.NotBlank;


public class QcmRequest {

@NotBlank
public String qcm;

public String getQcm(){
        return qcm;
    }
public void setQcm(String qcm){
        this.qcm=qcm;
    }


}
