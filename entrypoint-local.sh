#!/bin/bash

echo "starting"

JVM_OPTS_EXTRA="--add-opens java.base/java.lang=ALL-UNNAMED -Dlog4j2.formatMsgNoLookups=True -XX:FlightRecorderOptions=stackdepth=256"

AGENT_OPTS="-javaagent:$HOME/agent.jar"

echo "JVM_OPTS="$JVM_OPTS
# hostname should be docker container name on a custom bridged network to allow docker DNS resolution
export MONGODB_ADDRESS=localhost
echo "server.port="$SERVER_PORT
echo "spring.profiles.active="$SPRING_PROFILES_ACTIVE
echo "spring.kafka.bootstrap-servers="$SPRING_KAFKA_BOOTSTRAP_SERVERS
echo ""

java $JVM_OPTS $JVM_OPTS_EXTRA $AGENT_OPTS -jar $HOME/app.jar
