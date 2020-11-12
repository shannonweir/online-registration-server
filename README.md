# online-registration-server
This is a online registration server built using Spring Boot. It is a very basic CRUD api for users.

# Prerequisite
1. Docker
2. Maven

# Steps to run Online Registration Server
1. Make sure you have docker installed
2. Download a tar file attached to this project located at the following location "./online-registration-server/src/main/resources/mysql-image/mysql.tar". Note this path is relative to the project structure
3. Open cmd and load docker image using the following command: docker load -i mysql.tar
4. Make sure that the image is running by executing the following command: docker load -i mysql.tar
5. A record with a image name 'mysql:5.7' should appear and this will indicate that it is running 
6. Once it is running, run the following command to build the project: mvn clean install
7. Now start up your server by running: mvn spring-boot:run
