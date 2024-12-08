FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/*.jar

WORKDIR /app

COPY ${JAR_FILE}  /app/product.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/product.jar"]