FROM maven:3.8.4-jdk-8
COPY src /eureka-server/src
COPY pom.xml /eureka-server
WORKDIR eureka-server
RUN mvn clean package
