package mape.pattern.p06.observer;

import java.util.*;

public class Post {
    private Map<String, List<Observer>> subscribers = new HashMap<>();

    public void addSubscriber(String title, Observer subscriber) {
        subscribers.computeIfAbsent(title, k -> new LinkedList<>()).add(subscriber);
    }

    public void removeSubscriber(String title, Observer subscriber) {
        subscribers
                .getOrDefault(title, Collections.emptyList())
                .remove(subscriber);
    }

    public void obtain(String title) {
        System.out.println();
        System.out.println(title + " was obtained. Send to subscribers:");
        subscribers
                .getOrDefault(title, Collections.emptyList())
                .forEach(subscriber -> {
                    System.out.println("-->Sending " + title);
                    subscriber.send(title);
                });
    }
}
