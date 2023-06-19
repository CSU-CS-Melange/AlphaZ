#!/bin/bash

if [[ -z "$1" ]]; then
    echo "usage: $0 create|delete"
    exit
fi

if [[ "$1" == "create" ]]; then
    CMD="PUT"
elif [[ "$1" == "delete" ]]; then 
    CMD="DELETE"
fi

curl -L \
  -X ${CMD} \
  -H "Accept: application/vnd.github+json" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  -H "Authorization: Bearer ${MANAGE_ENV_TOKEN}" \
  https://api.github.com/repos/CSU-CS-Melange/AlphaZ/environments/test-pr-${PR_NUMBER}

