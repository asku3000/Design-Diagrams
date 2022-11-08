package com.scaler.eviction.strategies;

import com.scaler.eviction.interfaces.EvictionStrategy;
import com.scaler.eviction.observer.Consumer;
import com.scaler.eviction.observer.EventType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomEvictionStrategy<K> implements EvictionStrategy<K>, Consumer<K> {

    private List<K> keys = new ArrayList<>();

    @Override
    public K evict() {
        int randomIndex = ThreadLocalRandom
                .current()
                .nextInt(keys.size())
                % keys.size();

        return keys.get(randomIndex);
    }

    @Override
    public void notifyChange(EventType eventType, K key) {
        if (eventType == EventType.READ) {
            return;
        }

        keys.add(key);
    }
}
