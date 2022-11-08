package com.scaler.eviction;

import com.scaler.eviction.cache.InMemoryEvictionCache;
import com.scaler.eviction.interfaces.CacheEviction;
import com.scaler.eviction.strategies.RandomEvictionStrategy;
import com.scaler.first.inmemory.InMemoryCache;
import com.scaler.first.interfaces.Cache;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class CacheTest {

    private CacheEviction<String, String> cache;

    @Before
    public void setUp(){
        cache = new InMemoryEvictionCache(10, 1000, new RandomEvictionStrategy<String>());
    }

    @Test
    public void testCreateAndGet() {
        cache.put("Test", "TestString");
        String actual = cache.get("Test");

        assertEquals("If put is done, the value should be returned", "TestString", actual);
    }

    @Test(expected = RuntimeException.class)
    public void testCacheOverflow() {
        IntStream.range(0, 11)
                .forEach(index -> cache.put(
                        "Test_" + index, "TestString_" + index));
    }
}
