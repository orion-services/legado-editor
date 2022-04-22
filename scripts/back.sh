#!/bin/bash

cd ..
docker-compose up -d
./mvnw compile quarkus:dev
