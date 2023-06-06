#!/bin/bash

# makes an eclipse bundle with AlphaZ and all required dependencies

if [[ -z $1 ]]; then
    echo "usage: $0 OS"
    exit 1
fi

base_url="https://www.eclipse.org/downloads/download.php?file=/eclipse/downloads/drops4/R-4.22-202111241800"

if [[ $1 == "linux-x86" ]]; then
    OS="linux"
    eclipse_url="$base_url/eclipse-SDK-4.22-linux-gtk-x86_64.tar.gz"
    suffix="tar.gz"
elif [[ $1 == "mac-x86" ]]; then
    OS="mac"
    eclipse_url="$base_url/eclipse-SDK-4.22-macosx-cocoa-x86_64.dmg"
    suffix="dmg"
elif [[ $1 == "mac-aarch64" ]]; then
    OS="mac"
    eclipse_url="$base_url/eclipse-SDK-4.22-macosx-cocoa-aarch64.dmg"
    suffix="dmg"
else
    echo "error: unsupported OS type"
    exit 1
fi
version=$1

# this is passed by the action runner
if [[ -n "$GITHUB_SHA" ]]; then
    IN_ACTION_RUNNER=1
fi

rm -rf work
mkdir -p work

if [[ $OS == "linux" ]]; then
    wget -O eclipse.tar.gz $eclipse_url
    tar -xzf eclipse.tar.gz

    eclipse_instance="./eclipse/eclipse"

    # install GeCoS & Xtext plugins
    bash ./scripts/install-plugins.sh $eclipse_instance scripts/resources/required-plugins.p2f
    
    # install AlphaZ plugin
    if [[ -n "$IN_ACTION_RUNNER" ]]; then
        $eclipse_instance \
            -nosplash \
            -application org.eclipse.equinox.p2.director \
            -repository file:///home/runner/work/AlphaZ/AlphaZ/releng/alphaz.update/target/repository \
            -installIU alphaz.feature.feature.group
    else
        bash ./scripts/install-plugins.sh $eclipse_instance scripts/resources/alphaz-plugins-master.p2f
    fi
    
    tar -czf eclipse-alphaz-$version.tar.gz eclipse
fi

if [[ $OS == "mac" ]]; then
    mkdir -p eclipse-download-mac-x86
    if [[ ! -f eclipse-download-mac-x86/eclipse.dmg ]]; then
        wget -O eclipse-download-mac-x86/eclipse.dmg $eclipse_url
    fi
    hdiutil attach -nobrowse -mountpoint eclipse-mnt eclipse-download-mac-x86/eclipse.dmg 
    rm -rf alphaz-bundle/
    mkdir alphaz-bundle/
    cp -R eclipse-mnt/Eclipse.app alphaz-bundle/
    hdiutil detach eclipse-mnt

    eclipse_instance="./alphaz-bundle/Eclipse.app/Contents/MacOS/eclipse"

    # install GeCoS & Xtext plugins
    bash ./scripts/install-plugins.sh $eclipse_instance scripts/resources/required-plugins.p2f
    
    # install AlphaZ plugin
    if [[ -n "$IN_ACTION_RUNNER" ]]; then
        $eclipse_instance \
            -nosplash \
            -application org.eclipse.equinox.p2.director \
            -repository file:///Users/runner/work/AlphaZ/AlphaZ/releng/alphaz.update/target/repository \
            -installIU alphaz.feature.feature.group
    else
        bash ./scripts/install-plugins.sh $eclipse_instance scripts/resources/alphaz-plugins-master.p2f
    fi
    # create eclipse disk image file
    rm -f "eclipse-alphaz-$version.dmg"
    # sign the disk image if in action runner
    if [[ -n "$IN_ACTION_RUNNER" ]]; then
        eclipse_app="./alphaz-bundle/Eclipse.app"
        signing_identity=`security find-identity -v -p codesigning | cut -d' ' -f 4`
        /usr/bin/codesign --force -s $signing_identity $eclipse_app -v
    fi
    # add a symlink for the dmg and create the disk image
    ln -s /Applications alphaz-bundle/Applications
    hdiutil create -fs HFS+ -srcfolder alphaz-bundle -volname "eclipse-alphaz-$version" "eclipse-alphaz-$version.dmg"

fi

mkdir -p eclipse-bundle-$version
mv eclipse-alphaz-$version.$suffix eclipse-bundle-$version/
