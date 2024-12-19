# UCE Génie Logiciel Avancé : Techniques de tests

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.

# Projet GitHub

**Nom :** BASS  
**Prénom :** Amadou 
**Groupe :** M1 ILSEN CLA G1

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/amadoubassceri/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/amadoubassceri/ceri-m1-techniques-de-test/tree/master)
[![codecov](https://codecov.io/gh/amadoubassceri/ceri-m1-techniques-de-test/graph/badge.svg?token=FT2TF0IYHM)](https://codecov.io/gh/amadoubassceri/ceri-m1-techniques-de-test)

# CERI M1 Techniques de Test

## Description

Projet pour l'apprentissage des techniques de test d'API.

# TP1 : Fork them all !
### Épisode 1 - Récupération de l'API
j'ai forke le projet puis je l'ai clone avec : 
git clone https://github.com/amadoubassceri/ceri-m1-techniques-de-test.git
Le projet ne contient qu’un package Java fr.univavignon.pokedex.api, sous le répertoire src/main.
Et ce package contient l'Api.
### Épisode 2 - Création du projet Maven
Creation du projet maven avec un fichier nommé pom.xml et d’y décrire les cycles de vie de notre application.
###Épisode 3 - Synchronisation avec Git
Nous avons maintenant un projet opérationnel pour travailler, il faut maintenant commitet push les changements sur GitHub

# TP2 : (Dés)intégration continue
### Épisode 1 - CircleCI
J'ai utilise la plateforme CircleCi pour mettre en place une integration continue comme vu en cours.
J'ai utilise mon compte Github.
### Épisode 2 - circle.yml
CircleCI s’enregistre comme listener des événements de mon repository. Ainsi lorsque qu’on push un commit, CircleCI déclenche une intégration continue exécutée dans un conteneur.
La première étape de cette intégration continue est de chercher un fichier nommé circle.yml à la racine de mon repository, si ce fichier n’est pas trouvé l’intégration continue échouera.

# TP3 : Pokéunit
Les test unitaires.

# TP4 100% IV

Code Coverage et l'implementation du code

# TP5 checkstyles

# Les outils utilises :
Jacoco
CircleCi
CodeCov
Maven
CheckStyle

## Badges

- **CircleCI**: [![CircleCI](https://dl.circleci.com/status-badge/img/gh/amadoubassceri/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/amadoubassceri/ceri-m1-techniques-de-test/tree/master)
- **Codecov**: [![codecov](https://codecov.io/gh/amadoubassceri/ceri-m1-techniques-de-test/graph/badge.svg?token=FT2TF0IYHM)](https://codecov.io/gh/amadoubassceri/ceri-m1-techniques-de-test)

## Checkstyle Badge

[![Checkstyle](https://img.shields.io/badge/Checkstyle-E%3A0%20W%3A0%20I%3A0-brightgreen.svg)](https://github.com/checkstyle/checkstyle)

### Explication des badges

- **CircleCI Badge** : Montre l'état actuel du pipeline de build sur CircleCI.
- **Codecov Badge** : Affiche la couverture de code sur le projet à l'aide de Codecov.
- **Checkstyle Badge** : Indique le nombre d'erreurs (E), d'avertissements (W) et d'informations (I) détectées par le plugin Checkstyle.

## Intégration de l'implémentation de la Team Rocket

Nous avons intégré l'implémentation de la Team Rocket pour l'interface `IPokemonFactory` et l'avons testée avec notre suite de tests. Voici les principales étapes :

1. **Ajout de l'implémentation** : Copiez l'implémentation de `RocketPokemonFactory` fournie par la Team Rocket dans le répertoire `src/main/java` de votre projet.

2. **Exécution des tests** : Les tests existants couvrent déjà une grande partie des fonctionnalités. Pour exécuter les tests :

    ```bash
    mvn test
    ```
      ```bash
    mvn checkstyle
    ```

3. **Ajout de nouveaux tests** : Des tests ont été ajoutés pour vérifier les comportements non couverts, tels que la gestion des index négatifs et des erreurs de génération des statistiques aléatoires.

4. **Rapport de revue de code** : Un rapport a été rédigé pour signaler les défauts et proposer des améliorations, notamment concernant l'optimisation de la génération des statistiques et l'ajout de tests supplémentaires pour les cas d'erreurs non couverts.

L'implémentation a été intégrée et testée, avec des recommandations pour améliorer la performance et la gestion des exceptions.

# TP6
## Revue de code TeamRocket

Le code de la Team Rocket est vraiment pourrie.

- J'ai testé leurs codes et ces derniers ne passent pas du tout.
- Checkstyle a trouvé des erreurs. 
- Aucune exception levée si l'index est en dehors de [0,150]
- Les cp ne sont pas cohérents (pas bien géré à la création du pokemon)
- Pas de documentation javadocs