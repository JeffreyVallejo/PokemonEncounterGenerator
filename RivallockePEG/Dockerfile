FROM openjdk:11-jre-slim

ARG JAR_FILE=target/*.jar
RUN mkdir -p /resources

COPY ${JAR_FILE} app.jar
COPY ./src/main/resources ./resources
CMD ["java", "-jar", "/app.jar"]

EXPOSE 8080