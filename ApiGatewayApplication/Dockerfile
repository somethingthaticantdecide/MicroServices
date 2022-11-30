FROM maven:3.8.4-jdk-8
COPY src /app/src
COPY pom.xml /app
WORKDIR app
RUN mvn clean package
