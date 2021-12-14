FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim

VOLUME [ "/tmp" ]

EXPOSE 8080

ADD ./target/INTERCORP.Clients-0.0.1-SNAPSHOT.jar clients-service.jar

ENTRYPOINT [ "java", "-jar", "clients-service.jar" ]

