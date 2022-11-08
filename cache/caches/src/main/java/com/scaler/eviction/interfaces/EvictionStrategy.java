package com.scaler.eviction.interfaces;

public interface EvictionStrategy<K> {

    K evict();

}
