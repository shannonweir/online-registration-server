# online-registration-server
Online Registration Application

# Prerequisite
1. Docker
2. Maven

# Steps to run Online Registration Server
1. Make sure you have docker installed
2. Download tar file attached to this project located at the following location "/whatever.tar"
3. Open cmd and load docker image using the following command: docker load -i whatever.tar
4. Make sure that it is running by running the following command: docker load -i whatever.tar
5. A record with a image name 'mysql:5.7' should appear and that will indicate that it is running 
6. Once it is running, run the following command to build the project: mvn clean install
7. Now start up your server by running: mvn spring-boot:run
