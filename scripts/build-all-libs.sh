#!/bin/bash

if [[ -d "$HOME/complibs" && -z "$FORCE" ]]; then
  echo "This may overwrite some files in the directory '$HOME/complibs'"
  echo "To continue, either remove this directory or re-run with the environment"
  echo "variable FORCE=1"
  echo
  echo "Exiting and doing nothing..."
  exit 1
fi

# compile gmp
pushd bundles/edu.csu.melange.jnimap.isl/native/build/gmp
make
popd

# compile isl
pushd bundles/edu.csu.melange.jnimap.isl/native/build/isl
make
popd

# compile JNI bindings for isl (java)
pushd bundles/edu.csu.melange.jnimap.isl/native/build
make
popd

# compile cloog
pushd bundles/edu.csu.melange.jnimap.cloog/native/build/cloog
make
popd

# compile JNI bindings for cloog (java)
pushd bundles/edu.csu.melange.jnimap.cloog/native/build
make
popd
