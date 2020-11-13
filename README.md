# online-registration-server
This is a online registration server built using Spring Boot. It is a very basic CRUD api for users.

# Prerequisite
1. Docker
2. Maven

# Steps to run Online Registration Server
1. Make sure you have docker installed
2. Execute the following command to  run a MySQL 5.7 database in a container. Note if the image is not found. It will automatically download it for you. The command to execute is: 'docker run -it --name mysql-container -e MYSQL_ROOT_PASSWORD=Password123 -p 3310:3306 mysql:5.7'
3. You can check whether the relevent image has been pulled by executing the following command: 'docker images'
4. A "mysql 5.7' record should appear
5. You can also check whether the container is running by executing the folliowing command: 'docker container ls'
6. Again a 'mysql:5.7' should appear
7. Once the relevant images have been pulled and the container started, you can connect to OS using the exec command: 'docker exec -it mysql57-container mysql -u root -p'
4. The previous command will connect to the MySQL instance in the container directly from the host and will prompt you for a password. The password in this instance is 'Password123' 
5. Now run the the following command in the mysql terminal: CREATE database testdb;
4. Make sure that the image is running by executing the following command: docker images 
5. A record with a image name 'mysql:5.7' should appear 
6. Run the following command to build the project: mvn clean install
7. Now start up your server by running: mvn spring-boot:run
8. This server runs on http://localhost:8080. A simple api call would be http://localhost:8080/online-registration/api/users
