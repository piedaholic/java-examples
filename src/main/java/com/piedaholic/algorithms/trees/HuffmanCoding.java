package com.piedaholic.algorithms.trees;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.piedaholic.ds.linear.tuple.Tuple;

public class HuffmanCoding {
    public class Node {
        private Node() {
        }

        private Node(Character character, int frequency, Node left, Node right) {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        private Character character;
        private int frequency;
        private Node right;
        private Node left;

    }

    public Tuple<Node,String> encode(String str) {
        Tuple<Node, String> result = null;
        String encodedString = "";
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // populate hashmap
        for (int i = 0; i < str.length(); i++) {
            if (frequencyMap.containsKey(str.charAt(i)))
                frequencyMap.put(str.charAt(i), frequencyMap.get(str.charAt(i)) + 1);
            else
                frequencyMap.put(str.charAt(i), 1);
        }

        /*
         * Map<Character, Integer> sortedFrequencyMap = frequencyMap.entrySet().stream()
         * .sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::
         * getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
         */
        Node root = createHuffmanTree(frequencyMap);
        HashMap<Character, String> keys = generateKey(root);

        for (int i = 0; i < str.length(); i++) {
            encodedString = encodedString + keys.get(str.charAt(i));
        }
        result = new Tuple<>(root,encodedString);
        return result;
    }

    private Node createHuffmanTree(HashMap<Character, Integer> frequencyMap) {
        PriorityQueue<Node> pq = createPriorityQueue(frequencyMap);
        Node root = createHuffmanTree(pq);
        return root;
    }

    private Node createHuffmanTree(PriorityQueue<Node> pq) {
        while (pq.size() > 1) {

            Node x = pq.peek();
            pq.poll();

            Node y = pq.peek();
            pq.poll();

            Node node = new Node();

            node.left = x;
            node.right = y;

            node.frequency = x.frequency + y.frequency;

            pq.add(node);
        }
        return pq.peek();
    }

    private HashMap<Character, String> generateKey(Node root) {
        String key = "";
        HashMap<Character, String> hm = new HashMap<>();
        generateKey(root, key, hm);
        return hm;
    }

    private void generateKey(Node root, String str, HashMap<Character, String> hm) {
        if (root == null)
            return;
        if (root.character != null) {
            hm.put(root.character, str);
        }
        generateKey(root.left, str + "0", hm);
        generateKey(root.right, str + "1", hm);
    }

    public String decode(String encodedString, Node HuffmanTreeRoot) {
        HashMap<Character, String> keys = generateKey(HuffmanTreeRoot);
        return decode(encodedString, keys);
    }

    private String decode(String encodedString, HashMap<Character, String> keys) {
        String decodedString = "";
        boolean decoded = false;
        int startIndex = 0;
        int offset = 0;
        int endIndex = 0;
        while (!decoded) {
            for (Map.Entry<Character, String> e : keys.entrySet()) {
                offset = e.getValue().length();
                endIndex = startIndex + offset;
                if (endIndex > encodedString.length())
                    continue;
                String substring = encodedString.substring(startIndex, endIndex);
                if (substring.equals(e.getValue())) {
                    decodedString += e.getKey();
                    startIndex = endIndex;
                }
                if (startIndex == encodedString.length())
                    decoded = true;
            }
        }
        return decodedString;
    }

    public PriorityQueue<Node> createPriorityQueue(Map<Character, Integer> hm) {
        Comparator<Node> pqComparator = Comparator.comparingInt(l -> l.frequency);
        PriorityQueue<Node> pq = new PriorityQueue<>(pqComparator);
        hm.forEach((k, v) -> {
            pq.add(new Node(k, v, null, null));
        });
        return pq;

    }

    /*-
    private void traverseTree(Node root) {
        if (root.left != null && root.right != null) {
            traverseTree(root.left);
            traverseTree(root.right);
        }
    }
    
    private void printPriorityQueue(PriorityQueue<Node> pq) {
        pq.forEach(node -> {
            System.out.println(node.character);
            System.out.println(node.frequency);
        });
        */

}
