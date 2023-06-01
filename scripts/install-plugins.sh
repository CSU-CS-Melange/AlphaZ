#!/bin/bash

if [[ -z "$1" || -z "$2" ]]; then
  echo "usage: $0 ECLIPSE P2F_PLUGINS_FILE"
  exit 1
fi

ECLIPSE=$1
PLUGINS_P2F=$2

REPOS=""
for r in `cat ${PLUGINS_P2F} | grep 'repository loc' | sed "s|^.*='\(.*\)'.*$|\1|" | sort | uniq`
do 
    REPOS+="$r,"
done;
REPOS=$(echo $REPOS | sed 's|\(.*\),$|\1|')

IUIDS=""
ids=$(cat ${PLUGINS_P2F} | grep 'iu id' | sed "s|^.*iu id='\(.*\)' name.*$|\1|")
for iuid in $ids
do 
    IUIDS+="$iuid,"
done
IUIDS=$(echo $IUIDS | sed 's|\(.*\),$|\1|')

$ECLIPSE \
-nosplash \
-application org.eclipse.equinox.p2.director \
-repository $REPOS \
-installIU $IUIDS
