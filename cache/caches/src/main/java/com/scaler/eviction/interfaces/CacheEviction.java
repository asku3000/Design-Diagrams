package com.scaler.eviction.interfaces;

public interface CacheEviction<K, V> {

    V get(K key);

    void put(K key, V value);

    void remove(K key);
}
