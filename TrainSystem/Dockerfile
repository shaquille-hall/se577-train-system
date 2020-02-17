FROM maven:3.6.2
WORKDIR /app
COPY . .
#RUN sh wait-for-postgres.sh traindb mvn clean package
CMD mvn clean package
ENTRYPOINT java -jar target/TrainDemo-0.0.1-SNAPSHOT.jar