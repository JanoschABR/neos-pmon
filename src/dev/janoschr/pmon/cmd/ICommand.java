package dev.janoschr.pmon.cmd;

@FunctionalInterface
public interface ICommand <Result extends ICommandResult> {
    Result execute ();
}
