package com.piedaholic.algorithms.trees;

import static org.junit.Assert.assertTrue;

import com.piedaholic.algorithms.trees.HuffmanCoding.Node;
import com.piedaholic.ds.linear.Tuple;

import org.junit.Test;

public class TestHuffmanCoding {

    @Test
    public void test_Huffman_Encoding() {
        String testString = "Harsh";
        HuffmanCoding hc = new HuffmanCoding();
        Tuple<Node,String> tuple = hc.encode(testString);
        String decodedString = hc.decode(tuple.getSecond(),tuple.getFirst());
        assertTrue(testString.equals(decodedString));
    }
}
