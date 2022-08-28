package dev.janoschr.pmon;

import dev.janoschr.pmon.cmd.proc.MemInfo;
import dev.janoschr.pmon.cmd.proc.MemInfoResult;
import dev.janoschr.pmon.cmd.ps.PsAxlGrep;
import dev.janoschr.pmon.cmd.ps.PsAxlGrepResult;
import dev.janoschr.pmon.cmd.uptime.Uptime;
import dev.janoschr.pmon.cmd.uptime.UptimeResult;
import org.joda.time.Period;

public class Main {

    public static void main(String[] args) {

        // Print all data of Uptime
        UptimeResult uptime = new Uptime().execute();
        System.out.println(uptime);

        // Print all data of MemInfo
        MemInfoResult memInfo = new MemInfo().execute();
        System.out.println(memInfo);

        // Print all data of PsAxlGrep for any process named 'java'
        PsAxlGrepResult psAxlGrep = new PsAxlGrep("java").execute();
        System.out.println(psAxlGrep);
    }
}
