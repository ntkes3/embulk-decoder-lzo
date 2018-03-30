# Lzo decoder plugin for Embulk

TODO: Write short description here and build.gradle file.

## Overview

* **Plugin type**: decoder
* **Guess supported**: no

## Configuration


## Example

```yaml
in:
  type: any output input plugin type
  decoders:
    - type: lzo
exec:
  preview_sample_buffer_bytes: 65535

```

(If guess supported) you don't have to write `decoder:` section in the configuration file. After writing `in:` section, you can let embulk guess `decoder:` section using this command:

```
$ embulk gem install embulk-decoder-lzo
$ embulk guess -g lzo config.yml -o guessed.yml
```

## Build

```
$ ./gradlew gem  # -t to watch change of files and rebuild continuously
```
