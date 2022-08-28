package dev.janoschr.pmon.cmd.ps;

import dev.janoschr.pmon.cmd.ICommandResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PsAxlGrepResult implements ICommandResult {
    public List<PsAxlGrepEntry> entries = new ArrayList<>();

    @Override
    public String toString() {
        return "PsAxlGrepResult {" + entries + '}';
    }
}
