# B64

> Base64 encode/decode CLI application.

[![Travis (.org)](https://img.shields.io/travis/kenobi883/b64.svg?style=flat-square)](https://travis-ci.org/kenobi883/b64)
[![Codecov](https://img.shields.io/codecov/c/github/kenobi883/b64.svg?style=flat-square)](https://codecov.io/gh/kenobi883/b64)
![License](https://img.shields.io/github/license/kenobi883/b64.svg?style=flat-square)
![GitHub tag (latest SemVer)](https://img.shields.io/github/tag/kenobi883/b64.svg?style=flat-square)

## Install

Execute the install script to download pre-built binaries, extract them, and add them to your user's `PATH`.

```sh
eval $(curl -s https://raw.githubusercontent.com/kenobi883/b64/master/install.sh | bash -s)
```

**Note:** This application requires a Java runtime of 8 or higher to be on your `PATH`.
 
## Usage

- `b64 --help` - Print the help page and exit.
- `b64 --version` - Print the version and exit.
- `b64 encode <INPUT>` - Base64 encode the given string and exit. Quotes should be used for strings containing spaces.
- `b64 decode <INPUT>` - Base64 decode the given string and exit.

## Build

Build the CLI using Gradle. Execute the following command to generate tar and zip archives in `build/distributions`:

```sh
./gradlew clean build
```

Extract an archive and optionally add the resulting `bin` folder to your `PATH`:

```sh
tar -C build/distributions -xf build/distributions/b64-${VERSION}.tar
export PATH="${PATH}:$(pwd)/build/distributions/b64-${VERSION}/bin"
```
