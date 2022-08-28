package dev.janoschr.pmon.cmd.uptime;

import dev.janoschr.pmon.Utils;
import dev.janoschr.pmon.cmd.ICommandResult;
import org.joda.time.*;

public class UptimeResult implements ICommandResult {

    public LocalDateTime since;

    public Period getTimeSinceStartup () {
        return new Period(since, new LocalDateTime());
    }

    @Override
    public String toString() {
        return "UptimeSinceResult {" +
                "Since: " + Utils.stringifyDateTime(since.toDateTime()) +
                ", Uptime: " + Utils.stringifyPeriod(getTimeSinceStartup()) +
                '}';
    }
}
