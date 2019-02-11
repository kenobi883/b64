#!/bin/bash

# Set up
export VERSION=1.0.0-RC3
export ARCHIVE_FILE=b64-${VERSION}.tar.gz
export B64_BIN_DIR=${HOME}/bin/b64-${VERSION}/bin

# Download latest archive
curl -L -o ${ARCHIVE_FILE} https://github.com/kenobi883/b64/releases/download/v${VERSION}/b64-${VERSION}.tar

# Install to user's personal `bin` directory, and add to current $PATH
mkdir -p ${HOME}/bin
tar -C ${HOME}/bin -xf ${ARCHIVE_FILE}
echo "PATH=\"${PATH}:${B64_BIN_DIR}\"" >> ${HOME}/.profile
echo "PATH=\"${PATH}:${B64_BIN_DIR}\""

# Clean up
rm -f ${ARCHIVE_FILE}
export VERSION=
export ARCHIVE_FILE=
