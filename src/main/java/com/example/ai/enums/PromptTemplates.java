package com.example.ai.enums;

public class PromptTemplates {

 public static final String EXPLAIN_CONCEPT = """
  Explique le concept de : %s
  Niveau : %s

  Structure :
  1- Définition
  2- Explication
  3- Exemple code
  4- A retenir

 """;

 public static final String GENERATE_CODE = """
 Génère du code Java pour : %s
 Contraintes : %s 
 """;
}
