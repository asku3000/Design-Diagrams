package com.scaler.first.inmemory;

import com.scaler.first.interfaces.Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache<K, V> implements Cache<K, V> {

    private Integer capacity;

    private Integer ttl;//time to live

    //private Map<K, V> values = new HashMap<>();

    //to make thread safe
    private Map<K, V> values = new ConcurrentHashMap<>();

    public InMemoryCache(Integer capacity, Integer ttl){
        this.capacity= capacity;
        this.ttl = ttl;
    }

    @Override
    public void create(K key, V value) {
       if(values.size() >= capacity){
           throw new RuntimeException("Cache is full");
       }
        values.put(key, value);
    }

    @Override
    public V get(K key) {
        return values.get(key);
    }

    @Override
    public void update(K key, V value) {
        values.put(key, value);
    }

    @Override
    public void delete(K key) {
        values.remove(key);
    }
}
