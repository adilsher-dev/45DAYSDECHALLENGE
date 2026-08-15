package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> leftHeap;   // Max Heap
    private PriorityQueue<Integer> rightHeap;  // Min Heap

    public MedianFinder() {
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Insert into the correct heap
        if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
            leftHeap.offer(num);
        } else {
            rightHeap.offer(num);
        }

        // Step 2: Balance the heaps
        if (leftHeap.size() > rightHeap.size() + 1) {
            rightHeap.offer(leftHeap.poll());
        } else if (rightHeap.size() > leftHeap.size() + 1) {
            leftHeap.offer(rightHeap.poll());
        }
    }

    public double findMedian() {

        // If both heaps have equal size
        if (leftHeap.size() == rightHeap.size()) {

            if (leftHeap.isEmpty()) {
                return 0.0;
            }

            return ((double) leftHeap.peek() + rightHeap.peek()) / 2.0;
        }

        // If left heap has more elements
        if (leftHeap.size() > rightHeap.size()) {
            return leftHeap.peek();
        }

        // If right heap has more elements
        return rightHeap.peek();
    }
}