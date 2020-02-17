FROM maven:3.6.2
RUN apt-get update && apt-get install postgresql-client -y
WORKDIR /app
COPY . .
RUN mvn clean package -Dmaven.test.skip=true --quiet
ENTRYPOINT /bin/sh wait-for-postgres.sh java -jar /app/target/TrainDemo-0.0.1-SNAPSHOT.jar