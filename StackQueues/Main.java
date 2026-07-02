package StackQueues;
//LRU CACHE
import java.util.*;

public class Main {

    static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {

        int capacity;
        HashMap<Integer, Node> map;

        Node head, tail;

        LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();

            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        // Remove a node from DLL
        private void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        // Insert node just after head (Most Recently Used)
        private void insert(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        public int get(int key) {

            if (!map.containsKey(key))
                return -1;

            Node node = map.get(key);

            remove(node);
            insert(node);

            return node.value;
        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {

                Node node = map.get(key);
                node.value = value;

                remove(node);
                insert(node);
            }
            else {

                if (map.size() == capacity) {

                    Node lruNode = tail.prev;

                    remove(lruNode);
                    map.remove(lruNode.key);
                }

                Node newNode = new Node(key, value);

                insert(newNode);
                map.put(key, newNode);
            }
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3);

        System.out.println(cache.get(2)); // -1

        cache.put(4, 4);

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}