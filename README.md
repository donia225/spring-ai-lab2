# SPRING AI - Lab 2 : Prompt Engineering avec Spring AI

## 1 - Objectif du projet

Ce deuxième lab de la formation Spring AI a pour objectif de maîtriser la construction de prompts avec les rôles System et User, de découvrir les techniques de
prompting (Zero-shot, Few-shot), d'utiliser des prompts dynamiques et de structurer les réponses générées par un LLM dans une application Spring Boot.

## 2 - Technologies utilisées

- Java
- Spring Boot
- Spring AI
- Ollama
- Maven
- Postman

## 3 - Fonctionnalités réalisées

### Gestion des System et User Prompts

J'ai utilisé les rôles System et User pour définir le comportement du modèle et les instructions à suivre lors de la génération des réponses.

L'application permet d'expliquer des concepts informatiques en fonction du niveau de l'étudiant.

### Construction de prompts dynamiques

J'ai utilisé les Text Blocks et la méthode `formatted()` de Java pour construire des prompts dynamiques à partir des paramètres envoyés par l'utilisateur.

J'ai également expérimenté l'ajout du contexte de l'application pour obtenir des réponses plus adaptées.

### Structuration des réponses

J'ai ajouté des instructions pour demander au LLM de générer des réponses structurées au format Markdown, contenant une définition, une explication, un exemple
de code Java et les points importants à retenir.

J'ai également défini des contraintes sur la langue, la longueur des réponses et la validité du code généré.

### Techniques Zero-shot et Few-shot

J'ai expérimenté deux techniques de prompting :

- **Zero-shot** : génération d'un QCM sur le polymorphisme sans fournir d'exemple au modèle.
- **Few-shot** : génération d'une explication en fournissant au modèle un exemple sur l'héritage en Java.

### Organisation des prompts

J'ai créé les classes `PromptTemplates` et `PromptTemplateService` pour préparer la centralisation des templates de prompts et faciliter leur réutilisation.

## 4 - API REST

Les principales fonctionnalités sont exposées à travers des API REST.

| Méthode | Endpoint | Description |
|---|---|---|
| POST | `/api/ai/explain` | Expliquer un concept selon le niveau |
| POST | `/api/ai/explain-structured` | Générer une réponse structurée |
| POST | `/api/ai/qcm` | Générer un QCM avec Zero-shot |
| POST | `/api/ai/fewshots` | Expliquer un concept avec Few-shot |

## 5 - Test avec Postman

<img width="1750" height="803" alt="test-lab2" src="https://github.com/user-attachments/assets/1193939a-e2ae-4f6a-a6e8-7bd71e75f6d4" />



<img width="1752" height="860" alt="test-explainstructured-lab2" src="https://github.com/user-attachments/assets/66af0d21-b355-45e4-87af-1ef6cecb746e" />



<img width="1647" height="903" alt="test-explain-concept-template" src="https://github.com/user-attachments/assets/086806e5-a9c0-45bb-9ab8-58f37e2446da" />


## 6 - Compétences acquises
Ce lab m'a permis de mieux comprendre le Prompt Engineering, la différence entre les rôles System et User, les techniques Zero-shot et Few-shot, la création et
l'adaptation de templates de prompts, ainsi que l'importance des instructions données au LLM pour améliorer la pertinence des réponses.
