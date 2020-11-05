#!/bin/sh
mvn package && docker build -f Dockerfile.quarkus-openj9 -t pingperf-quarkus-openj9 .
