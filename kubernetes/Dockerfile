FROM openjdk:8
COPY target/customer-api.jar customer.mv.db /app/
WORKDIR /app/
CMD ["java", "-jar", "customer-api.jar"]

