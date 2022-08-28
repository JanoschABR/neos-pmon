package dev.janoschr.pmon.cmd.proc;

import dev.janoschr.pmon.cmd.CommandUtils;
import dev.janoschr.pmon.cmd.ICommand;

public class MemInfo implements ICommand<MemInfoResult> {

    // Example output:
    //  MemTotal:       32834488 kB
    //  MemFree:        24823204 kB
    //  MemAvailable:   29736140 kB
    //  Buffers:         1106300 kB
    //  Cached:          4380416 kB
    //  SwapCached:            0 kB
    //  Active:          5659032 kB
    // ...

    @Override
    public MemInfoResult execute() {
        try {
            MemInfoResult result = new MemInfoResult();

            String rawData = CommandUtils.runBashProcess("cat /proc/meminfo");
            if (rawData == null) return null;

            String[] lines = rawData.split("\n");

            for (String line : lines) {
                String[] parts = line.trim().replaceAll(" +", " ").split(" ");

                String key = parts[0].replace(":", "");
                long value = (Long.parseLong(parts[1]) * 1024);

                result.entries.put(key, value);
            }

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
