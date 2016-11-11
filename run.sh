#!/usr/bin/bash -ex

BENCH_PATH=`pwd`;
cd $BENCH_PATH;

if [ ! -z "$1" ]; then
  JSONP_VER="-DjsonpVersion=$1"
else
  JSONP_VER=""
fi

mvn clean install ${JSONP_VER};
java -jar target/benchmarks.jar -prof stack -f 1 -t 4 -i 10

