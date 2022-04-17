# Editor Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Run application

docker-compose up -d

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Build a editor container

mvn package
docker build -f src/main/docker/Dockerfile.jvm -t editor-service .
docker run -i --rm -p 8080:8080 editor-service

## Stop and remove all containers with docker-compose

docker-compose down

## Remove all images

docker rmi $(docker images -q)

## Run on another Debug port

./mvnw compile quarkus:dev -Ddebug=5006
