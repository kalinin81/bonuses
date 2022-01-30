FROM circleci/jdk8:0.1.1
WORKDIR /app
COPY ./target/bonuses-0.0.1-SNAPSHOT.jar /app
CMD ["java", "-jar", "bonuses-0.0.1-SNAPSHOT.jar"]