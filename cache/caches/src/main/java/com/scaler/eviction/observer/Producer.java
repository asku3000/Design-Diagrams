package com.scaler.eviction.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Producer<KEY> {

    List<Consumer<KEY>> consumers = new ArrayList<>();

    public void register(Consumer<KEY> consumer) {
        consumers.add(consumer);
    }

    public void deregister(Consumer<KEY> consumer) {
        consumers.remove(consumer);
    }

    public void notifyConsumers(EventType eventType, KEY key) {
        consumers.forEach(consumer -> consumer.notifyChange(eventType, key));
    }

}
