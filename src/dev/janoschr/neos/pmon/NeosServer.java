package dev.janoschr.neos.pmon;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NeosServer extends WebSocketServer {

    public static String message = "";
    protected static HashMap<WebSocket, Thread> threads = new HashMap<>();

    public NeosServer (InetSocketAddress addr) {
        super(addr);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        Thread thread = new Thread(() -> {
            Runnable refresh = () -> {
                webSocket.send(message);
            };

            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(refresh, 0, 4, TimeUnit.SECONDS);
        });

        threads.put(webSocket, thread);
        thread.start();
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        threads.get(webSocket).interrupt();
        threads.remove(webSocket);
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) { }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        e.printStackTrace();
    }

    @Override
    public void onStart() { }
}
