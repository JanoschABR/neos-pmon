package dev.janoschr.pmon.cmd.uptime;

import dev.janoschr.pmon.cmd.CommandUtils;
import dev.janoschr.pmon.cmd.ICommand;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Uptime implements ICommand<UptimeResult> {

    // Example output:
    //  08:55:27 up 44 days, 21:35,  7 users,  load average: 0.47, 0.49, 0.54

    @Override
    public UptimeResult execute() {
        try {
            UptimeResult result = new UptimeResult();

            String rawData = CommandUtils.runBashProcess("uptime --since");
            if (rawData == null) return null;

            DateTimeFormatter formatter = DateTimeFormat.forPattern("YYYY-MM-DD HH:mm:ss");
            result.since = LocalDateTime.parse(rawData.trim(), formatter);

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
