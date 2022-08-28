package dev.janoschr.pmon.cmd.ps;

import dev.janoschr.pmon.cmd.CommandUtils;
import dev.janoschr.pmon.cmd.ICommand;
import org.joda.time.Duration;

public class PsAxlGrep implements ICommand<PsAxlGrepResult> {

    // Example output:
    //  F   UID   PID  PPID PRI  NI    VSZ   RSS WCHAN  STAT TTY        TIME COMMAND
    //  5  1001   585   579  20   0  14572  6052 -      S    ?          0:00 sshd: janosch@notty
    //  0  1001   586   585  20   0   2452  1796 -      Ss   ?          0:00 /usr/lib/openssh/sftp-server
    //  0  1001   691 32516  20   0  10544  1276 -      R+   pts/0      0:00 ps xl
    //  5  1001 32507 32501  20   0  14712  6032 -      S    ?          0:00 sshd: janosch@notty
    //  0  1001 32508 32507  20   0   2452  1792 -      Ss   ?          0:00 /usr/lib/openssh/sftp-server
    // ...

    protected String grepValue = null;
    public PsAxlGrep (String grep) {
        this.grepValue = grep;
    }

    @Override
    public PsAxlGrepResult execute() {
        try {
            PsAxlGrepResult result = new PsAxlGrepResult();

            String rawData = CommandUtils.runBashProcess("ps axl | grep " + grepValue);
            if (rawData == null) return null;

            String[] lines = rawData.split("\n");

            boolean first = true;
            for (String line : lines) {

                // Skip the first entry (the header)
                if (first) { first = false; continue; }

                PsAxlGrepEntry entry = new PsAxlGrepEntry();
                String[] parts = line.trim().replaceAll(" +", " ").split(" ");
                entry.uid = parts[1];
                entry.pid = Integer.parseInt(parts[2]);
                entry.tty = parts[10];

                // Parse the time
                String[] time =  parts[11].split(":");
                int uptimeHours = Integer.parseInt(time[0]);
                int uptimeMinutes = Integer.parseInt(time[1]);

                Duration duration = new Duration(0);
                duration = duration.plus(Duration.standardHours(uptimeHours));
                entry.time = duration.plus(Duration.standardMinutes(uptimeMinutes));


                // TODO: Improve command parsing -- Could easily break
                entry.command = line.substring(line.indexOf(" ", 68)).trim();

                result.entries.add(entry);
            }

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
