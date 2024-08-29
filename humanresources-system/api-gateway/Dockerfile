FROM maven:3-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre

ARG JAR_FILE=/app/target/*.jar

WORKDIR /app

COPY --from=build ${JAR_FILE} app.jar

CMD ["java", "-jar", "app.jar"]
