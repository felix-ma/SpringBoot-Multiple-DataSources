package cn.felix.multipledatsource.common.cache;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述：
 * 实现一个线程安全的map
 * @author potter
 * @create 2018-06-13 18:09
 */
public class SimpleConcurrentMap<K, V> implements Map<K, V> {

    final ReadWriteLock lock = new ReentrantReadWriteLock();

    final Lock r = lock.readLock();

    final Lock w = lock.writeLock();

    final Map<K, V> map;

    public SimpleConcurrentMap(Map<K, V> map) {
        this.map = map;
        if (map == null) throw new NullPointerException();
    }

    public void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

    public boolean containsKey(Object key) {
        r.lock();
        try {
            return map.containsKey(key);
        } finally {
            r.unlock();
        }
    }

    public boolean containsValue(Object value) {
        r.lock();
        try {
            return map.containsValue(value);
        } finally {
            r.unlock();
        }
    }

    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    public V get(Object key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public boolean isEmpty() {
        r.lock();
        try {
            return map.isEmpty();
        } finally {
            r.unlock();
        }
    }

    public Set<K> keySet() {
        r.lock();
        try {
            return new HashSet<K>(map.keySet());
        } finally {
            r.unlock();
        }
    }

    public V put(K key, V value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        w.lock();
        try {
            map.putAll(m);
        } finally {
            w.unlock();
        }
    }

    public V remove(Object key) {
        w.lock();
        try {
            return map.remove(key);
        } finally {
            w.unlock();
        }
    }

    public int size() {
        r.lock();
        try {
            return map.size();
        } finally {
            r.unlock();
        }
    }

    public Collection<V> values() {
        r.lock();
        try {
            return new ArrayList<V>(map.values());
        } finally {
            r.unlock();
        }
    }
}
