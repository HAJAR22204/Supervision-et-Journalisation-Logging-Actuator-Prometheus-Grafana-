# Projet de Supervision et Monitoring - TP8

## 1. Présentation du Projet
Ce dépôt contient la solution technique pour le TP8 portant sur l'observabilité des applications Spring Boot. L'enjeu majeur est de transformer une application Java classique en un système monitoré, capable de fournir des indicateurs de performance en temps réel pour des environnements de production DevOps.

## 2. Architecture Technique
La solution repose sur une pile logicielle moderne :
- **Spring Boot 3.2.4** : Framework applicatif.
- **Spring Boot Actuator** : Exposition des métriques internes.
- **Micrometer & Prometheus Registry** : Formatage des données pour le collecteur.
- **Prometheus** : Base de données de séries temporelles pour la collecte.
- **Grafana** : Interface de visualisation et de dashboarding.
- **Docker Compose** : Orchestration des services de monitoring.

## 3. Détails de l'Implémentation

### Supervision Applicative (Actuator)
L'application expose ses points de contrôle via `/actuator`. Nous avons configuré une exposition totale (`*`) pour permettre une analyse fine de la santé du système (`/health`), des informations de build (`/info`) et des métriques JVM (`/metrics`).

### Stratégie de Journalisation (Logging)
Le système de log a été structuré pour répondre aux besoins de production :
- **Rotation et Persistance** : Les logs sont écrits dans `logs/system.log`.
- **Formatage** : Utilisation d'un pattern précis incluant le timestamp, le thread et le niveau de sévérité.
- **Niveaux de Log** : Passage en `DEBUG` pour le code métier afin de tracer précisément le cycle de vie des requêtes.

### Collecte et Visualisation
- **Prometheus** : Configuré pour "scraper" l'application toutes les 5 secondes.
- **Grafana** : Utilise le dashboard standard `4701` pour afficher l'utilisation CPU, la latence HTTP et l'état de la mémoire Heap.

## 4. Analyse des Résultats du TP
L'exécution des tests a permis de valider les points suivants :
- **Observabilité Réelle** : Les temps de réponse simulés (500ms) sont correctement capturés et moyennés dans Grafana.
- **Traçabilité** : Chaque appel à l'endpoint `/execute-task` génère une entrée de log explicite et incrémente un compteur personnalisé (`app.execution.total`) visible dans Prometheus.
- **Réactivité** : L'état `UP` de l'application est immédiatement détectable, permettant une intégration facile avec des systèmes d'alerte.

## 5. Bonnes Pratiques Appliquées
- **Séparation des préoccupations** : Logique métier isolée dans des services.
- **Métriques Métier** : Ajout de compteurs spécifiques au domaine plutôt que de se limiter aux métriques techniques.
- **Conteneurisation** : Utilisation de Docker pour garantir la reproductibilité de l'environnement de monitoring.

## Conclusion
Ce TP démontre qu'une application moderne ne se limite pas à ses fonctionnalités métier. L'ajout d'une couche d'observabilité robuste est indispensable pour garantir la résilience et la maintenabilité des systèmes distribués.

---
**GroupId :** ma.ens
**ArtifactId :** tp8-monitoring
