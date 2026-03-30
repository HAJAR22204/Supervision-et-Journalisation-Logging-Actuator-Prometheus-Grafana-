# Rapport de TP8 : Supervision et Monitoring Spring Boot

## Introduction
Ce projet implémente une solution complète de monitoring pour une application Spring Boot. L'objectif est de transformer une application "boîte noire" en un système observable en utilisant les standards de l'industrie : Spring Boot Actuator, Prometheus et Grafana.

## Résultats et Analyse

### 1. Spring Boot Actuator
L'activation de l'Actuator permet d'exposer des points de terminaison critiques :
- `/actuator/health` : Confirme que l'application est opérationnelle (`UP`).
- `/actuator/info` : Affiche les métadonnées de l'application.
- `/actuator/metrics` : Fournit des détails techniques sur la JVM (mémoire, CPU, threads).

### 2. Journalisation (Logging)
La configuration personnalisée dans `application.properties` permet :
- Une sortie structurée dans la console pour le développement.
- La persistance des logs dans `logs/system.log` pour l'analyse post-mortem.
- Un niveau de log `DEBUG` pour le package `ma.ens.tp8monitoring`, facilitant le traçage des requêtes.

### 3. Intégration Prometheus
Grâce à Micrometer, les métriques sont converties au format Prometheus. L'endpoint `/actuator/prometheus` expose des compteurs tels que `app.execution.total` (métrique personnalisée) et `http_server_requests_seconds_count`.

### 4. Visualisation Grafana
L'utilisation du tableau de bord ID `4701` permet de visualiser en temps réel :
- Le débit des requêtes HTTP.
- La latence moyenne des traitements (simulée à 500ms dans notre service).
- L'état de santé de la mémoire Heap.

## Conclusion
La mise en place de cette chaîne d'observabilité permet une gestion proactive des incidents. L'application n'est plus seulement un exécutable, mais un système dont on peut mesurer la performance et la fiabilité de manière continue.

---
**Groupe :** ma.ens
**Artifact :** tp8-monitoring
