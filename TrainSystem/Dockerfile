FROM maven:3.6.2
WORKDIR /app
COPY . .
#RUN sh wait-for-postgres.sh traindb mvn clean package
ENTRYPOINT mvn clean package