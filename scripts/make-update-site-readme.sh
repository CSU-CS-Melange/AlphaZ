#!/bin/bash

readme_file=./releng/alphaz.update/target/repository/README.md

linux_x86_tar="eclipse-alphaz-linux-x86.tar.gz"
mac_x86_dmg="eclipse-alphaz-mac-x86.dmg"
#mac_aarch64_dmg="eclipse-alphaz-mac-aarch64.dmg"

base_url="https://csu-cs-melange.github.io/AlphaZ"
linux_x86_link="$base_url/downloads/$linux_x86_tar"
mac_x86_link="$base_url/downloads/$mac_x86_dmg"
#mac_aarch64_link="$base_url/downloads/$mac_aarch64_dmg"

base_filepath="./releng/alphaz.update/target/repository"
linux_x86_file="$base_filepath/downloads/$linux_x86_tar"
mac_x86_file="$base_filepath/downloads/$mac_x86_dmg"
#mac_aarch64_file="$base_filepath/downloads/$mac_aarch64_dmg"

linux_x86_size=$(ls -lh $linux_x86_file | awk '{print  $5}')
mac_x86_size=$(ls -lh $mac_x86_file | awk '{print  $5}')
#mac_aarch64_size=$(ls -lh $mac_aarch64_file | awk '{print  $5}')

linux_x86_sha=$(shasum $linux_x86_file | cut -d' ' -f1)
mac_x86_sha=$(shasum $mac_x86_file | cut -d' ' -f1)
#mac_aarch64_sha=$(shasum $mac_aarch64_file | cut -d' ' -f1)

cat > $readme_file <<EOF
This endpoint acts as the Eclipse update site used for AlphaZ. Last generated on \``date`\` from commit \``echo $GITHUB_SHA`\`.

## Eclipse bundles

The following Eclipse bundles contain the AlphaZ plugin and all of its required dependencies.

| Platform | Download | Size | SHA1 Checksum |
| --- | --- | --- | --- |
| Linux (x86_64) | [$linux_x86_tar]($linux_x86_link) | $linux_x86_size | $linux_x86_sha |
| Mac (x86_64) | [$mac_x86_dmg]($mac_x86_link) | $mac_x86_size | $mac_x86_sha |

EOF
