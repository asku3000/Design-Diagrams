package com.scaler.eviction.observer;

public interface Consumer<KEY> {

    void notifyChange(EventType eventType, KEY key);
}