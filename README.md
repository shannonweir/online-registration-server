# online-registration-server
This is a online registration server built using Spring Boot. It is a very basic CRUD api for users.

# Prerequisite
1. Docker
2. Maven

# Steps to run Online Registration Server
1. Make sure you have docker installed
2. Execute the following command to  run a MySQL 5.7 database in a container: docker run -dit --name mysql-container -e MYSQL_ROOT_PASSWORD=Password123 -p 3310:3306 mysql:5.7
3. Once the relevant images have been pulled and the container started, we can connect to OS using the exec command by executing the follwing command: docker exec -it mysql57-con bash
3. Open cmd and load docker image using the following command: docker load -i mysql.tar
4. Make sure that the image is running by executing the following command: docker load -i mysql.tar
5. A record with a image name 'mysql:5.7' should appear and this will indicate that it is running 
6. Once it is running, run the following command to build the project: mvn clean install
7. Now start up your server by running: mvn spring-boot:run
8. This server runs on http://localhost:8080. A simple api call would be http://localhost:8080/online-registration/api/users
