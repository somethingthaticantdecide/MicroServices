FROM maven:3.8.4-jdk-8
COPY src /CountriesApplication/src
COPY pom.xml /CountriesApplication
WORKDIR CountriesApplication
RUN mvn clean package