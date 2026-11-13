package com.example.ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service 
public class PromptService {

private final ChatClient chatClient;
private final PromptTemplateService templateService;

public PromptService(ChatClient.Builder chatClientBuilder, PromptTemplateService templateService) {
    this.chatClient = chatClientBuilder.build();
    this.templateService = templateService;
}



public String explainConceptStructured(String concept, String level){
    String systemPrompt =" Tu es un tuteur patient en programmation Java.";

    String userPrompt= """
    Explique le concept de : %s
    Niveau de l'étudiant : %s
    
    
    Structure de la réponse EXACTEMENT comme suit:
    1. **Définition**: Une phrase concise.
    2. **Explication**: Analogie simple si possible.
    3. **Exemple**: Un petit snippet de code Java.
    4. **A retenir**: 3 points clés sous forme de liste à puces.
    
    Sois soucis et pédagogique.
    """.formatted(concept, level);
    return chatClient
                    .prompt()
                    .system(systemPrompt)
                    .user(userPrompt)
                    .call()
                    .content();

}

public String explainWitchContext(String concept, String level, String appContext){
    String systemPrompt= "Tu es un ingénieur logiciel senior.";

    String userPrompt= """
    Contexte de l'application : %s
    
    Explique le concept de : 
    <concept>%s</concept>
    Niveau : %s
    
    Format de sortie:
    - Définition
    - Analogie
    - Code exemple
    - Points clés
    """.formatted(appContext, concept, level);
    return chatClient
            .prompt()
            .system(systemPrompt)
            .user(userPrompt)
            .call()
            .content();
}

public String zeroShotExplain(String qcm) {
    String prompt = """
        Génère un QCM de 5 questions sur le polymorphisme.
        """.formatted(qcm);
        
    return chatClient.prompt()
            .user(prompt)
            .call()
            .content();
}

public String fewShotExplain(String concept){
    String prompt = """
    Tu dois expliquer des concepts techniques.
    
    Exemple :
    Concept : Héritage
    Définition : Mécanisme par lequel une classe dérive d'une autre.
    Explication : Comme un enfant hérite des traits de ses parents.
    Exemple code : class Dog extends Animal {}
    A retenir : 1. Réutilisation du code. 2. Is-a relationship.
    
    Ta tâche :
    concept : %s
    """.formatted(concept);
    return chatClient.prompt()
                     .user(prompt)
                     .call()
                     .content();
}

public String explainWithLanguageAndMarkdown(String concept){
    String systemPrompt = "Tu es un expert en java";
    String userPrompt = """
    Réponds UNIQUEMENT en Français.
    
    Explique le concept de : %s
    
    Format de sortie (Markdown) :
    ### Définition
    [Texte ici]
    
    ### Explication
    [Texte ici]
    
    ### Exemple
    ```java
    [Code ici]
    ```
    ### A retenir
    - point 1
    - point 2
    """.formatted(concept);
    return chatClient.prompt(systemPrompt)
                     .user(userPrompt)
                     .call()
                     .content();
}

public String explainConcept(String concept, String level){
    String systemPrompt = """ 
            Tu es un tuteur expert en programmation Java.
            Tu es patient, clair et pédagogique.
            Tu réponds toujours en français.
            """;

    String userPrompt = """
    Explique le concept de : %s;
    Niveau de l'étudiant : %s

    Respecte STRICTEMENT ce format Markdown :
            
            ### Définition
            [Une phrase concise]
            
            ### Explication
            [2-3 phrases avec une analogie simple]
            
            ### Exemple
            ```java
            [Le code doit être compilable et sans erreurs de syntaxe]
            ```
            
            ### À retenir
            - [Point clé 1]
            - [Point clé 2]
            - [Point clé 3]
            
            Contraintes :
            - Pas de préambule.
            - Maximum 200 mots.
            - Code Java valide.
            """.formatted(concept, level);
            
        
        return chatClient.prompt()
                .system(systemPrompt)
                .user(userPrompt)
                .call()
                .content();
    
        // String prompt = templateService.buildExplainPrompt(concept, level);

        //     return chatClient.prompt()
        //             .system("Tu es un expert Java.")
        //             .user(prompt)
        //             .call()
        //             .content();

}


}
