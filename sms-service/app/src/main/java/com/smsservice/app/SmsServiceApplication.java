package com.smsservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SmsServiceApplication {

//    public static class MinHeap {
//        private List<Integer> heap = new ArrayList<>();
//        private int size;
//
//        public MinHeap(int size) {
//            this.size = size;
//        }
//
//        public void insert(int val) {
//            heap.add(val);
//            int currentIndex = heap.size() - 1;
//
//            while (currentIndex >= 0) {
//                int parentIndex = (currentIndex - 1) / 2;
//                if (heap.get(currentIndex) < heap.get(parentIndex)) {
//                    swap(currentIndex, parentIndex);
//                    currentIndex = parentIndex;
//                } else {
//                    break;
//                }
//            }
//
//            if (heap.size() > size) {
//                System.out.println("Before: " + heap);
//                extractMin();
//                System.out.println("After: " + heap);
//            }
//        }
//
//        private int leftChild(int index) {
//            return index * 2 + 1;
//        }
//
//        private int rightChild(int index) {
//            return index * 2 + 2;
//        }
//
//        public void extractMin() {
//            if (heap.size() > 0) {
//                int lastEle = heap.remove(heap.size() - 1);
//                heap.set(0, lastEle);
//
//                int currentIndex = 0;
//                while (heap.size() > 1) {
//                    int left = leftChild(currentIndex);
//                    int right = rightChild(currentIndex);
//
//                    int smallest = currentIndex;
//
//                    if (left < heap.size() && heap.get(smallest) > heap.get(left)) {
//                        smallest = left;
//                    }
//                    if (right < heap.size() && heap.get(smallest) > heap.get(right)) {
//                        smallest = right;
//                    }
//
//                    if (smallest == currentIndex) {
//                        break;
//                    }
//
//                    swap(currentIndex, smallest);
//                    currentIndex = smallest;
//                }
//            }
//
//        }
//
//        public void swap(int i, int j) {
//            int temp = heap.get(i);
//            heap.set(i, heap.get(j));
//            heap.set(j, temp);
//        }
//
//    }
private static Map<Integer, Integer> map = new HashMap<>();
    public static class MaxHeap {
        private List<List<Integer>> heap = new ArrayList<>();
        private int size;

        public MaxHeap(int size) {
            this.size = size;
        }

        public void insert(int a, int b) {
            int sum = a + b;
            List<Integer> node = List.of(a,b, sum);

            heap.add(node);
            int currentIndex = heap.size() - 1;
            int parentIndex = (currentIndex - 1) / 2;
            while (parentIndex >= 0 && sum > heap.get(parentIndex).get(2)) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1) / 2;
            }

            if (heap.size() > size) {
                extractMax();
            }
            System.out.println(heap.toString());
            heap.stream().anyMatch(item-> node.equals(item));
        }

        private void swap(int i, int j) {
            List<Integer> temp = heap.get(j);
            heap.set(j, heap.get(i));
            heap.set(i, temp);
        }

        public void extractMax() {
            var element = heap.remove(heap.size() - 1);
            heap.set(0, element);

            int currentIndex = 0;
            while (heap.size() > 1) {
                int left = currentIndex * 2 + 1;
                int right = currentIndex * 2 + 2;

                int smaller = currentIndex;

                if (left < size && heap.get(left).get(2) > heap.get(smaller).get(2)) {
                    smaller = left;
                }


                if (right < size && heap.get(right).get(2) > heap.get(smaller).get(2)) {
                    smaller = right;
                }

                if (smaller == currentIndex) {
                    break;
                }

                swap(currentIndex, smaller);
                currentIndex = smaller;

            }

        }

    }
    public static void main(String[] args) {
//        List<int[]> list = new ArrayList<>();
//        list.stream();
//        MaxHeap minHeap = new MaxHeap(3);
//        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
////        System.arraycopy();
//        minHeap.insert(1,2);
//        minHeap.insert(1,4);
//        minHeap.insert(1,6);
//        minHeap.insert(7,2);
//        minHeap.insert(7,4);
//        minHeap.insert(7,6);
//        minHeap.insert(11,2);
//        minHeap.insert(11,4);
//        minHeap.insert(11,6);
//        Stack<Integer> stack = new Stack<>();
//        stack.pop();

        char a = 'v';
        System.out.println(Character.isAlphabetic(a));
        System.out.println(Character.isAlphabetic(':'));
        System.out.println(Character.isAlphabetic(' '));
        List<Integer> avc = new ArrayList<>();
        avc.getLast();
        String temp = "abcd";
        int[] av = new int[] {1,2};
        Character.isDigit('1');
//        System.out.println(minHeap.heap.toString());

//        return new int[2];
        SpringApplication.run(SmsServiceApplication.class, args);
    }
}
