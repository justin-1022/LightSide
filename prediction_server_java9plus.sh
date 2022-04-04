#!/bin/bash

# Usage: scripts/predicton_server.sh 
# Runs the prediction server on port 8000


MAXHEAP="4g"
OS_ARGS=""
OTHER_ARGS="-Djava.awt.headless=true"

MAIN_CLASS="edu.cmu.side.recipe.PredictionServer"
JAR="LightSide.jar"

ADD_OPENS1="java.base/java.util=ALL-UNNAMED"
ADD_OPENS2="java.xml/com.sun.org.apache.xml.internal.serialize=ALL-UNNAMED"
  
java -cp $JAR $OS_ARGS -Xmx$MAXHEAP $OTHER_ARGS --add-opens $ADD_OPENS1 --add-opens $ADD_OPENS2 $MAIN_CLASS "$@"

