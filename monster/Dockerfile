FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ARG CONFIG_FILE=src/main/resources/application.yml
COPY ${JAR_FILE} /application/application.jar
COPY ${CONFIG_FILE} /application/config/application.yml
WORKDIR /application
ENTRYPOINT ["java","-jar","application.jar","--spring.config.location=/application/config/"]