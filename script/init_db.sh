#!/bin/bash

docker run --rm -P -p 127.0.0.1:5432:5432 -v pgdata:/var/lib/postgresql/data -e POSTGRES_PASSWORD="postgres" -e POSTGRES_USER="postgres" --name postgres-covid postgres:alpine
