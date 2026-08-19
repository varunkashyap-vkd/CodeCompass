/*
 * The LLD Runbook — Part 2, Problem 1: LRU Cache
 *
 * The design as it stood at the end of the interview: a bounded cache whose eviction
 * rule is a collaborator rather than a line of code, so swapping LRU for MRU is a
 * constructor argument instead of a rewrite.
 *
 * Keys and values are int for readability; the printed version is generic.
 *
 * Run with:  java LruCacheDemo.java     (Java 11 or later)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LruCacheDemo {

    /** One entry and its links. It carries its own key so eviction can clean the index. */
    static class Node {
        final int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Holds the order entries leave in: head is most recent, tail is least.
     * Sentinel head and tail nodes mean no link operation ever needs a null check.
     */
    static class RecencyList {
        private final Node head = new Node(0, 0);
        private final Node tail = new Node(0, 0);

        RecencyList() {
            head.next = tail;
            tail.prev = head;
        }

        void addFront(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        /** Relinks a node it is handed. It never searches for one. */
        void moveToFront(Node node) {
            remove(node);
            addFront(node);
        }

        Node mostRecent() {
            return head.next == tail ? null : head.next;
        }

        Node leastRecent() {
            return tail.prev == head ? null : tail.prev;
        }

        List<Integer> keys() {
            List<Integer> keys = new ArrayList<>();
            for (Node n = head.next; n != tail; n = n.next) {
                keys.add(n.key);
            }
            return keys;
        }
    }

    /** The one decision the cache does not make for itself. */
    interface EvictionPolicy {
        Node select(RecencyList order);
    }

    static class LruPolicy implements EvictionPolicy {
        @Override
        public Node select(RecencyList order) {
            return order.leastRecent();
        }
    }

    /** The follow-up. One new class, and a constructor argument to wire it in. */
    static class MruPolicy implements EvictionPolicy {
        @Override
        public Node select(RecencyList order) {
            return order.mostRecent();
        }
    }

    /**
     * Owns the index and the recency list, and leaves both consistent after every call.
     *
     * Invariants: every key has exactly one node, present in both structures;
     *             size never exceeds capacity.
     */
    static class LruCache {
        private final Map<Integer, Node> index = new HashMap<>();
        private final RecencyList order = new RecencyList();
        private final int capacity;
        private final EvictionPolicy policy;

        LruCache(int capacity, EvictionPolicy policy) {
            if (capacity < 1) {
                throw new IllegalArgumentException("capacity must be at least 1");
            }
            this.capacity = capacity;
            this.policy = policy;
        }

        /** Returns null on a miss. A hit promotes the key, which makes every read a write. */
        Integer get(int key) {
            Node hit = index.get(key);
            if (hit == null) {
                return null;
            }
            order.moveToFront(hit);
            return hit.value;
        }

        void put(int key, int value) {
            Node hit = index.get(key);
            if (hit != null) {
                hit.value = value;
                order.moveToFront(hit);
                return;                      // no new node, nothing evicted
            }
            if (index.size() == capacity) {
                evictOne();
            }
            Node node = new Node(key, value);
            order.addFront(node);
            index.put(key, node);
        }

        /** The only place the eviction rule is consulted. */
        private void evictOne() {
            Node victim = policy.select(order);
            order.remove(victim);
            index.remove(victim.key);
        }

        List<Integer> keys() {
            return order.keys();
        }
    }

    public static void main(String[] args) {
        System.out.println("LRU — the least recently used entry leaves");
        trace(new LruCache(3, new LruPolicy()));

        System.out.println();
        System.out.println("MRU — same cache, same storage, one different constructor argument");
        trace(new LruCache(3, new MruPolicy()));
    }

    /** The six calls traced on page 5 of the runbook. */
    private static void trace(LruCache cache) {
        cache.put(1, 100);
        show(cache, "put(1, 100)");

        cache.put(2, 200);
        show(cache, "put(2, 200)");

        cache.put(3, 300);
        show(cache, "put(3, 300)");

        Integer hit = cache.get(1);
        show(cache, "get(1) -> " + hit);

        cache.put(4, 400);
        show(cache, "put(4, 400)");

        cache.put(1, 900);
        show(cache, "put(1, 900)");
    }

    private static void show(LruCache cache, String call) {
        System.out.printf("  %-18s keys, most recent first = %s%n", call, cache.keys());
    }
}
