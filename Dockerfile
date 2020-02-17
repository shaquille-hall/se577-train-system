FROM maven:3.6.2
RUN apt-get update && apt-get install postgresql-client -y
WORKDIR /app
COPY . .
CMD sh wait-for-postgres.sh mvn clean package
ENTRYPOINT sh wait-for-postgres.sh java -jar target/TrainDemo-0.0.1-SNAPSHOT.jar