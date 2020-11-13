# online-registration-server
This is a online registration server built using Spring Boot. It is a very basic CRUD api for users.

# Prerequisite
1. Docker
2. Maven

# Steps to run Online Registration Server
1. Make sure you have docker installed
2. Open cmd
3. Execute the following command to  run a MySQL 5.7 database in a container. Note if the image is not found. It will automatically download it for you. The command to execute is: 'docker run -it --name mysql-container -e MYSQL_ROOT_PASSWORD=Password123 -p 3310:3306 mysql:5.7'
4. You can check whether the relevent image has been pulled by executing the following command: 'docker images'
5. A record with a repository named 'mysql' should be listed. 
6. You can also check whether the container is running by executing the folliowing command: 'docker container ls'
7. A record with a name called 'mysql-container' should be listed. 
8. Once the relevant images have been pulled and the container started, you can connect to the OS using the exec command: 'docker exec -it mysql-container mysql -u root -p'
9. The previous command will connect to the MySQL instance in the container directly from the host and will prompt you for a password. The password in this instance is 'Password123'. This will open up a sql terminal in the same window.
10. Now run the the following command in the mysql terminal: 'CREATE database testdb;'
11. To check that your database has been created run the following command to show databases: 'show databases;'. Note 'testdb' should have been created 
12. Close the terminal by executing the following command: 'exit'
13. Navigate to this project root
14. Run the following command to build the project: mvn clean install
15. Now start up your server by running: mvn spring-boot:run
16. This server runs on http://localhost:8080. A simple api call would be http://localhost:8080/online-registration/api/users
