// Last updated: 18/05/2025, 13:33:36
class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public synchronized int get(int key) {
        if(this.containsKey(key))
            return cache.get(key);
        
        return -1;
    }
    
    public synchronized void put(int key, int value) {
        cache.put(key, value);
    }

    public synchronized boolean containsKey(int key) {
        return cache.containsKey(key);
    }

    public synchronized void clear() {
        cache.clear();
    }

    public synchronized int size() {
        return cache.size();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */