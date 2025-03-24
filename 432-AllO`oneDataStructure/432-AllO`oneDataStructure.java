// Last updated: 24/03/2025, 00:34:14
class AllOne {
    class Bucket {
        int count;
        Set<String> keys;
        Bucket prev, next;

        Bucket(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Bucket head, tail;
    private Map<String, Bucket> keyBucketMap;

    public AllOne() {
        head = new Bucket(-1); 
        tail = new Bucket(-1);
        head.next = tail;
        tail.prev = head;
        keyBucketMap = new HashMap<>();
    }

    public void inc(String key) {
        if (!keyBucketMap.containsKey(key)) {
            if (head.next.count != 1) {
                insertBucketAfter(head, new Bucket(1));
            }
            head.next.keys.add(key);
            keyBucketMap.put(key, head.next);
        } else {
            Bucket curr = keyBucketMap.get(key);
            Bucket next = curr.next;
            int newCount = curr.count + 1;

            if (next == tail || next.count != newCount) {
                next = insertBucketAfter(curr, new Bucket(newCount));
            }

            next.keys.add(key);
            keyBucketMap.put(key, next);

            curr.keys.remove(key);
            if (curr.keys.isEmpty()) removeBucket(curr);
        }
    }

    public void dec(String key) {
        Bucket curr = keyBucketMap.get(key);
        if (curr.count == 1) {
            curr.keys.remove(key);
            keyBucketMap.remove(key);
        } else {
            Bucket prev = curr.prev;
            int newCount = curr.count - 1;

            if (prev == head || prev.count != newCount) {
                prev = insertBucketAfter(curr.prev, new Bucket(newCount));
            }

            prev.keys.add(key);
            keyBucketMap.put(key, prev);

            curr.keys.remove(key);
        }

        if (curr.keys.isEmpty()) removeBucket(curr);
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private Bucket insertBucketAfter(Bucket prev, Bucket newBucket) {
        newBucket.prev = prev;
        newBucket.next = prev.next;
        prev.next.prev = newBucket;
        prev.next = newBucket;
        return newBucket;
    }

    private void removeBucket(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
    }
}