#!/bin/bash

# Set up
export VERSION=1.0.0-RC1
export ARCHIVE_FILE=b64-${VERSION}.tar.gz
export B64_BIN_DIR=${HOME}/bin/b64-${VERSION}/bin

# Download latest archive
curl -L -o ${ARCHIVE_FILE} https://github.com/kenobi883/b64/archive/v${VERSION}.tar.gz

# Install to user's personal `bin` directory, and add to current $PATH
mkdir -p ${HOME}/bin
tar -C ${HOME}/bin -xzf ${ARCHIVE_FILE}
echo "export PATH=\"${PATH}:${B64_BIN_DIR}\"" >> ${HOME}/.bashrc
export PATH="${PATH}:${B64_BIN_DIR}"

# Test install
b64 --version

# Clean up
rm -f ${ARCHIVE_FILE}
export VERSION=
export ARCHIVE_FILE=
