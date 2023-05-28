#!/bin/bash

readme_file=./releng/alphaz.update/target/repository/README.md


cat > $readme_file <<EOF
This endpoint acts as the Eclipse update site used for AlphaZ. Last generated on \``date`\` from commit \``echo $GITHUB_SHA`\`.
EOF
