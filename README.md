# Neos PMON
A simple performance monitor for headless [Neos](https://neos.com/) servers, based on my [PMON](https://github.com/JanoschABR/pmon) project.

*Note: Because of how PMON is designed, this will only work on a Linux machine.  
See PMON's README.md for more info.*

## Overview
I made Neos-PMON for my own use with my own headless server.  
It uses PMON to read information about the host machine and sends it to Neos using a WebSocket.

## Message Structure
*The WebSocket will be hosted on port `19420`*

The WebSocket messages consist of some numbers, followed by the DateTime the server started up:  
`[12;2;17179869184;876123123],2022-08-28 08:35:21`

The numbers are formatted specifically so they can be easily parsed using the [Parse Long4](https://wiki.neosvr.com/Parse_Long4_(LogiX_node)) node.  
The numbers are as following:
  * User CPU usage (in %)
  * System CPU usage (in %)
  * Total memory (estimated, in bytes)
  * Used memory (estimated, in bytes)

## In-Game Example
![Screenshot](https://github.com/JanoschABR/neos-pmon/blob/main/example.png)

## Dependencies
Following Maven dependencies are required for building:
* `joda-time:joda-time:2.10.14`
* `org.java-websocket:java-websocket:1.5.3`
* `org.slf4j:slf4j-simple:1.7.36`
