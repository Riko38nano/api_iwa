#!/bin/bash

gradle :build
sudo docker build -t root:1 .

cd ./apiGateway || exit
gradle :build
sudo docker build -t apigateway:1 .
cd ../

cd ./account || exit
gradle :build
sudo docker build -t account:1 .
cd ../