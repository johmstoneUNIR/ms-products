FROM openjdk:11
EXPOSE 8888
VOLUME /temp
COPY target/ms-products-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]