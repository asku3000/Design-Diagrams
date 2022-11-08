package com.scaler.first.interfaces;

public interface Cache<K, V> {

    public void create(K key, V value);

    public V get(K key);

    public void update(K key, V value);

    public void delete(K key);
}
