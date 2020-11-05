#!/bin/sh
docker run -v /home/stratum/local-dev/8build/images/j2sdk-image:/root/8build -ti --rm --privileged -p 8080:8080 --network host pingperf-quarkus-openj9
