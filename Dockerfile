FROM maven:3.9.8-eclipse-temurin-21 AS build
RUN mkdir /opt/app
COPY . /opt/app
WORKDIR /opt/app

#RUN mvn clean package
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
RUN mkdir /opt/app
COPY --from=build /opt/app/target/irrigationapi-0.0.1.jar /opt/app/app.jar
WORKDIR /opt/app
ENV PROFILE=prd
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]