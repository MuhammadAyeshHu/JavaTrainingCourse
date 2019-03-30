Connection to Database:

###Installation steps: 
#####Install mysql in docker for windows
https://dev.mysql.com/doc/mysql-installation-excerpt/5.5/en/linux-installation-docker.html

#####Install docker: 
https://download.docker.com/win/stable/Docker%20for%20Windows%20Installer.exe

####Download Connector/J
https://dev.mysql.com/downloads/connector/j/ 

Extract the .zip file and add the JAR file to libraries "mysql-connector-java-8.0.15.jar"
 
File -> Project structure -> Libraries -> add new Java library 
 
###Commands:
#######Install mysql image:

docker pull mysql/mysql-server

#######To check : 

docker images

#######Run docker image
docker run -p 3306:3306 -p 33060:33060 --name mySQLContainer -e MYSQL_ROOT_PASSWORD=passWord -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -d mysql/mysql-server

#######To check : 
docker ps

#######Run docker container 
docker exec -it mySQLContainer mysql -uroot -p 
ALTER USER 'admin'@'%' IDENTIFIED BY 'admin';

grant all privileges on \*.* to 'admin'@'%' with grant option;

flush privileges;

#####Previous steps are only for the first time, next times you will need to start the docker container only

#######Start docker container
docker ps -all

docker start dockerID

where dockerID is the mySQLContainer ID listed from the previous command