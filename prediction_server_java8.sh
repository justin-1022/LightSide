#!/bin/bash

# Usage: scripts/predicton_server.sh 
# Runs the prediction server on port 8000


MAXHEAP="4g"
OS_ARGS=""
OTHER_ARGS="-Djava.awt.headless=true"

MAIN_CLASS="edu.cmu.side.recipe.PredictionServer"
JAR="LightSide.jar"
  
java -cp $JAR $OS_ARGS -Xmx$MAXHEAP $OTHER_ARGS $MAIN_CLASS "$@"

