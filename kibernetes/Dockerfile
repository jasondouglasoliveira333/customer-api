FROM openjdk:8
COPY target/taxone-mapper-api.jar target/taxone.mv.db /app/
WORKDIR /app/
CMD ["java", "-jar", "taxone-mapper-api.jar"]

