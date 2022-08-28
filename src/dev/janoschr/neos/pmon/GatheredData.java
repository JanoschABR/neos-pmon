package dev.janoschr.neos.pmon;

import dev.janoschr.pmon.Utils;
import dev.janoschr.pmon.cmd.proc.MemInfoResult;
import dev.janoschr.pmon.cmd.uptime.UptimeResult;
import dev.janoschr.pmon.cmd.vmstat.VMStatResult;

public class GatheredData {

    public VMStatResult vmStat;
    public MemInfoResult memInfo;
    public UptimeResult uptime;

    public String generateMessage () {
        return String.format(
                "[%d;%d;%d;%d],%s",
                vmStat.cpuTimeUser,
                vmStat.cpuTimeSystem,
                memInfo.getTotalMemory(),
                memInfo.getUsedMemory(),
                Utils.stringifyDateTime(uptime.since.toDateTime())
        );
    }
}
