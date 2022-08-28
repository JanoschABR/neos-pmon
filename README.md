# Neos PMON
A simple performance monitor for headless [Neos](https://neos.com/) servers, based on my [PMON](https://github.com/JanoschABR/pmon) project.

*Note: Because of how PMON is designed, this will only work if you have your headless server hosted on a Linux machine*

## Overview
I made Neos-PMON for my own use with my own headless server.  
It uses PMON to read information about the host machine and sends it to Neos using a WebSocket.

The WebSocket messages are plain text which can directly be shown to the user.

## Dependencies
Following Maven dependencies are required for building:
* `joda-time:joda-time:2.10.14`
* `org.java-websocket:java-websocket:1.5.3`
* `org.slf4j:slf4j-simple:1.7.36`
