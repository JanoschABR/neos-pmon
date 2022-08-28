package dev.janoschr.pmon.cmd.proc;

import dev.janoschr.pmon.cmd.ICommandResult;
import org.joda.time.Duration;
import org.joda.time.LocalTime;

import java.util.HashMap;

public class MemInfoResult implements ICommandResult {

    public HashMap<String, Long> entries = new HashMap<>();

    public long getEntry (String key) {
        return entries.getOrDefault(key, 0L);
    }

    public long getTotalMemory () {
        return getEntry("MemTotal");
    }

    public long getFreeMemory () {
        return getEntry("MemFree");
    }

    public long getAvailableMemory () {
        return getEntry("MemAvailable");
    }

    public long getUsedMemory () {
        return (getTotalMemory() - getFreeMemory());
    }

    @Override
    public String toString() {
        return "MemInfoResult {" +
                 "Total: " + getTotalMemory() +
                ", Free: " + getFreeMemory() +
                ", Available: " + getAvailableMemory() +
                ", Used: " + getUsedMemory() +
                '}';
    }
}
