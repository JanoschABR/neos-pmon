package dev.janoschr.neos.pmon;

import dev.janoschr.pmon.cmd.proc.MemInfo;
import dev.janoschr.pmon.cmd.uptime.Uptime;
import dev.janoschr.pmon.cmd.vmstat.VMStat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DataGatherer extends Thread {

    public GatheredData executeCommands() {
        GatheredData data = new GatheredData();
        data.memInfo = new MemInfo().execute();
        data.uptime = new Uptime().execute();
        data.vmStat = new VMStat().execute();
        return data;
    }

    public static GatheredData lastGatheredData = null;

    @Override
    public void run() {

        Runnable refresh = () -> {
            lastGatheredData = executeCommands();
            NeosServer.message = lastGatheredData.generateMessage();
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(refresh, 0, 1, TimeUnit.SECONDS);
    }
}
