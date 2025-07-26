package server.service;

import lib.event.GameEvent;
import lib.event.JoinEvent;
import lib.model.Player;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class EventService {

    private Map<String, Queue<GameEvent>> eventQueues = new ConcurrentHashMap<>();


    public void createEventQueue(String id) {
        eventQueues.put(id, new LinkedBlockingQueue<>());
    }

    public void addJoinEvent(String gameId, Player player) {

        JoinEvent joinEvent = new JoinEvent(gameId, player);
        Queue<GameEvent> queue = eventQueues.get(gameId);

        queue.add(joinEvent);

        //TODO: notify new event was added
    }
}
