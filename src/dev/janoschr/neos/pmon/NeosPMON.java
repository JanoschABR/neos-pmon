package dev.janoschr.neos.pmon;

import java.net.InetSocketAddress;

public class NeosPMON {

    public static void start (int wsPort) {
        NeosServer server = new NeosServer(new InetSocketAddress(wsPort));
        server.start();

        new DataGatherer().start();
    }

}
