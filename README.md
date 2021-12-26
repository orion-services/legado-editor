# Editor Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Hint

If any port is already being used

- to kill port: sudo kill -9 `sudo lsof -t -i:7000`
- netstat -anop | grep 8080
- kill -9 id
-p kill -9 -f tomcat

If you need to take a drastic measure regarding the Docker files

- to kill all docker files: docker rm -f $(docker ps -a -q);docker system prune --volumes -a -f

## Run on another Debug port (When several services are turning simultaneously)

./mvnw compile quarkus:dev -Ddebug=5006
