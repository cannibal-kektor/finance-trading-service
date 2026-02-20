FROM maven:3-eclipse-temurin-25 AS builder

WORKDIR /opt/build/app/finance-trading-service

COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn -B dependency:resolve-plugins dependency:resolve

COPY src src
RUN --mount=type=cache,target=/root/.m2 mvn -B -DskipTests package

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=builder /opt/build/app/finance-trading-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
