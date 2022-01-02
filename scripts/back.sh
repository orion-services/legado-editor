#!/bin/bash

# function cd_up() {
#   cd $(printf "%0.s../" $(seq 1 $1 ));
# }
# alias 'cd..'='cd_up'
# (You could define this in ~/.bashrc if you want it in every instance).

cd ..
./mvnw package
docker-compose up -d