**Quarkus pingperf with OpenJ9 snapshot+restore**

Pingperf has been modified to snapshot after first request has been received.

**Setup:**
1. `cd quarkus`
2. Add local Java 8 snapshot+restore build as a volume in `quarkus/run-quarkus-boot-openj9.sh`
- Replace /home/stratum/local-dev/8build/images/j2sdk-image with local Java home path
3. Install wrk on local machine https://github.com/wg/wrk/wiki/Installing-Wrk-on-Linux

**Run application:**
1. Build: `sudo ./build-quarkus-openj9.sh`
2. Start docker: `sudo ./run-quarkus-boot-openj9.sh`
3. Snapshot/Restore commands are setup as aliases in docker container. Run either 'run_snapshot' or 'run_restore' in command line
4. Send request to application from another terminal. For example: `for run in {1..2}; do wrk -t1 -c1 -d1s http://0.0.0.0:8080/ping/simple; done`
