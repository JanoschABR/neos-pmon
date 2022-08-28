# PMON
Some stuff I made for reading memory and CPU usage, among other things, on a Linux machine.  

## Overview
PMON is so simple you can barely call it a library.  
It runs built-in linux bash commands to gather information, such as CPU usage.

The following information can be retrieved using PMON:
* Using `MemInfo`:
  * Total memory
  * Free memory
  * Available memory
  * Used memory
  * Any other value in `/proc/meminfo` (Using `getEntry()`)
  
* Using `PsAxlGrep`:
  * UID of a process
  * PID of a process
  * TTY a process was started in
  * Uptime of a process
  * The command used to start a process
  
* Using `Uptime`:
  * `LocalDateTime` of when the machine was started
  * Time since the machine was started 

## Examples
```java
// Reading the used amount of memory using MemInfo

MemInfoResult memInfo = new MemInfo().execute();
long usedMemory = memInfo.getUsedMemory();
```
```java
// Reading some other value using MemInfo

MemInfoResult memInfo = new MemInfo().execute();
long cachedMemory = memInfo.getEntry("Cached");
```
```java
// Reading the time since startup using UpTime

UptimeResult uptime = new Uptime().execute();
Period period = uptime.getTimeSinceStartup();
```

*The `Main.java` includes more stuff you can look at.*

## Dependencies
PMON uses the [Joda Time](https://www.joda.org/joda-time/index.html) library for keeping track of uptime and such.  
This should automatically get setup for you if you load the project in the [IntelliJ Idea](https://www.jetbrains.com/idea/) IDE.

Joda Time also has a [Maven Repository](https://mvnrepository.com/artifact/joda-time/joda-time) where you can download it manually.

## iT dOesN'T WorK On WINDOwS
PMON was made specifically for linux.  
***This does not and never will work on Windows or MacOS***
