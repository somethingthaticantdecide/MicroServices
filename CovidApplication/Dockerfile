FROM maven:3.8.4-jdk-8
COPY src /CovidApplication/src
COPY pom.xml /CovidApplication
WORKDIR CovidApplication
RUN mvn clean package
