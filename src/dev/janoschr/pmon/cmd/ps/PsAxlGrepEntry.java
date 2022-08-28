package dev.janoschr.pmon.cmd.ps;

import dev.janoschr.pmon.Utils;
import org.joda.time.Duration;

public class PsAxlGrepEntry {
    public String uid;
    public int pid;
    public String tty;
    public Duration time;
    public String command;

    @Override
    public String toString() {
        return "PsAxlGrepEntry {" +
                "uid: " + uid +
                ", pid: " + pid +
                ", tty: '" + tty + '\'' +
                ", time: " + Utils.stringifyDuration(time) +
                ", command: '" + command + '\'' +
                '}';
    }
}
