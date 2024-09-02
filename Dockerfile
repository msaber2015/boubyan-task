#
# Build stage
#
FROM maven:3-openjdk-17-slim AS Ph1
WORKDIR /app
COPY . /app/
RUN mvn -f /app/pom.xml clean package

#
# Run stage
#
FROM openjdk:17-jdk-alpine
EXPOSE 9092
COPY --from=Ph1 /app/target/*.jar task.jar
ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=cloud /task.jar"]