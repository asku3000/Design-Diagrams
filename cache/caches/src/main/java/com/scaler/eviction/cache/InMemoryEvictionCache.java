package com.scaler.eviction.cache;

import com.scaler.eviction.interfaces.CacheEviction;
import com.scaler.eviction.interfaces.EvictionStrategy;
import com.scaler.eviction.observer.EventType;
import com.scaler.eviction.observer.Producer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Same as earlier one but with modification
public class InMemoryEvictionCache<K, V> extends Producer<K> implements CacheEviction<K, V> {

    private final Integer capacity;

    private final Integer ttl;//time to live

    //private Map<K, V> values = new HashMap<>();

    //to make thread safe
    private final Map<K, V> cache = new ConcurrentHashMap<>();

    private final EvictionStrategy<K> evictionStrategy;

    public InMemoryEvictionCache(Integer capacity, Integer ttl, EvictionStrategy<K> evictionStrategy) {
        this.capacity = capacity;
        this.ttl = ttl;
        this.evictionStrategy = evictionStrategy;
    }


    @Override
    public V get(K key) {
        notifyConsumers(EventType.READ, key);
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {

        if (cache.size() == capacity) {
            K keyToEvict = evictionStrategy.evict();
            remove(keyToEvict);
        }

        notifyConsumers(EventType.WRITE, key);
        cache.put(key, value);
    }

    @Override
    public void remove(K key) {
        notifyConsumers(EventType.DELETE, key);
        cache.remove(key);
    }

    Map<K, V> getCache() {
        return cache;
    }
}
