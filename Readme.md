# Gestion des Comptes Bancaires - Projet Java Console

## 1. Description du Projet
Ce projet est une application console Java permettant la gestion complète des comptes bancaires. Il simule les fonctionnalités classiques d’une banque : création de comptes, versements, retraits, virements, consultation du solde et des opérations.

L’objectif est de mettre en pratique les concepts suivants :
- Programmation orientée objet (POO) avec Java
- Gestion des exceptions personnalisées
- Abstraction et héritage (comptes et opérations)
- Gestion des collections (`Map`, `List`)
- Architecture en couches : Présentation, Métier, Utilitaire

---

## 2. Architecture du Projet
Le projet est structuré en **trois couches principales** :

### 2.1 Couche Métier (`metier`)
Cette couche contient toute la logique métier et les classes principales du projet :

| Classe | Description |
|--------|-------------|
| `Compte` | Classe abstraite représentant un compte bancaire avec un solde et une liste d’opérations. |
| `CompteCourant` | Hérite de `Compte`. Possède un découvert autorisé. Redéfinit le retrait selon les règles du découvert. |
| `CompteEpargne` | Hérite de `Compte`. Possède un taux d’intérêt. Retrait limité au solde disponible. |
| `Operation` | Classe abstraite représentant une opération bancaire avec numéro, date et montant. |
| `Versement` | Hérite de `Operation`. Contient la source du versement. |
| `Retrait` | Hérite de `Operation`. Contient la destination du retrait (ATM, chèque…). |
| `BanqueService` | Classe principale gérant les comptes, les opérations et les interactions entre comptes. |
| `OperationException` | Exception personnalisée pour gérer les erreurs liées aux opérations bancaires. |

### 2.2 Couche Présentation (`presentation`)
Cette couche gère l’interface utilisateur via la console :

- `Menu.java` : Menu interactif permettant à l’utilisateur de :
    1. Créer un compte (courant ou épargne)
    2. Effectuer un versement
    3. Effectuer un retrait
    4. Effectuer un virement
    5. Consulter le solde d’un compte
    6. Consulter les opérations d’un compte

- Gestion complète des exceptions et validation des saisies utilisateur.

### 2.3 Couche Utilitaire (`util`)
Cette couche contient des classes utilitaires pour simplifier l’affichage et le formatage :

- `BanqueUtils.java` (facultatif) :
    - Méthodes pour afficher des messages de succès ou d’erreur
    - Méthodes pour formater les montants
    - Méthodes pour afficher les détails d’un compte ou d’une opération

---

## 3. Fonctionnalités Implémentées
1. **Création de comptes**
    - Compte courant avec solde initial et découvert autorisé
    - Compte épargne avec solde initial et taux d’intérêt
    - Génération automatique d’un code unique pour chaque compte

2. **Gestion des opérations**
    - Versements avec saisie de la source
    - Retraits avec contrôle du solde ou du découvert
    - Virements entre comptes avec vérification des codes et montants

3. **Consultation des données**
    - Solde d’un compte
    - Liste complète des opérations avec détails (numéro, date, montant, source/destination)

4. **Sécurité et validation**
    - Gestion des exceptions (`OperationException`)
    - Validation des entrées utilisateur (montants positifs, codes existants…)

5. **Affichage clair et lisible**
    - Méthodes `afficherDetails()` et `toString()` pour les comptes et opérations
    - Messages formatés pour le succès ou l’erreur des opérations

---

## 4. Organisation des Packages
project-root/
│
├── metier/
│ ├── Compte.java
│ ├── CompteCourant.java
│ ├── CompteEpargne.java
│ ├── Operation.java
│ ├── Versement.java
│ ├── Retrait.java
│ ├── BanqueService.java
│ └── OperationException.java
│
├── presentation/
│ └── Menu.java
│
└── util/
└── BanqueUtils.java (optionnel)

---

## 5. Instructions pour Lancer le Projet
1. Cloner ou télécharger le projet.
2. Ouvrir le projet dans **IntelliJ IDEA** ou tout IDE Java.
3. Compiler toutes les classes.
4. Exécuter la classe principale `Menu` depuis le package `presentation`.
5. Suivre le menu interactif pour créer des comptes et effectuer des opérations.

---
## 6. Exemple d’Utilisation
=== Menu Banque ===

Créer un compte

Effectuer un versement

Effectuer un retrait

Effectuer un virement

Consulter le solde d'un compte

Consulter les opérations d'un compte

Quitter
Choix : 1

Créer un compte :

Compte Courant

Compte Épargne
Votre choix : 1
Solde initial : 1000
Découvert autorisé : 500
Compte courant créé ! Code du compte : CPT-00001

Choix : 2
Code du compte : CPT-00001
Montant à verser : 200
Source du versement : Espèces
Versement effectué avec succès !

## 7. Bonnes Pratiques Utilisées
- Architecture en **couches** (Séparation présentation / métier / utilitaire)
- **POO avancée** : héritage, abstraction, encapsulation
- Gestion des **exceptions métier**
- **Listes et Maps** pour stocker et gérer les comptes et opérations
- Méthodes utilitaires pour un **affichage uniforme et lisible** 