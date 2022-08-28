package dev.janoschr.pmon.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandUtils {
    public static Process startBashProcess (String command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", command);
        return processBuilder.start();
    }

    public static String runBashProcess (String command) {
        try {
            // Start the process
            Process process = startBashProcess(command);
            StringBuilder output = new StringBuilder();

            String line; // Create a reader
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Read all data from the process
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to exit
            process.waitFor();

            return output.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
