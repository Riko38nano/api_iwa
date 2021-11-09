### RUN THE APP

$ sudo bash ./script/init_db.sh
start a docker on localhost:5432 for the database

### this does not create the database in the docker
## enter docker
$ sudo docker exec -it postgres-covid psql -U postgres
-# create database covid_alert_db;
-# \q
$ docker cp ./script/create_tables_covid.sql postgres-covid:/create_tables.sql

### relancer le 1er script

### plutot que de faire des configurations, la branche test contient la version avec les
### urls, pass et user de la base local

### tous les microservice doivent etre lancé séparément dans le tooltab "Gradle"
### il faut ajouter les microservices à la main avec le + du menu Gradle et
### séléctionner "account", "apiGateway"


### l'apiGateway écoute sur le port 9090
### sur les routes
### /api/users pour le ms account
### /pie/{nom} pour l'exemple

### la config de securité du ms "account" créer un user root admin
### name : admin
### pass : toto
### pour relancer l'app il faut commenter ses lignes
### (L51, 52 dans CovidAlertSecurityConfig package config dans account)


### 