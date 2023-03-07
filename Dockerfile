FROM openjdk:17
EXPOSE 8080
ADD target/employee-management.jar employee-management.jar
ENTRYPOINT ["java","-jar","/employee-management.jar"]



#docker commands
#docker images - to list all images
#docker container - to list all running containers
#docker ps - to see all docker contatiers
#docker build -t <jar name> . - to build the docker
#docker run -p 9090:8080 <jar name>
