#!/bin/bash

cd ..
docker-compose -f docker-compose.override.yml up -d
./mvnw compile quarkus:dev
