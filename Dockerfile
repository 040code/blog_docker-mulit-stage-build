FROM openjdk:8u121-jre-alpine
COPY build/libs/notes-service.jar /app/notes-service.jar

EXPOSE 8080
CMD java -jar /app/notes-service.jar
