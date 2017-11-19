package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;
import com.kchmielewski.sda.tree.DefaultBinarySearchTree;

import java.util.stream.IntStream;

class BinarySearchTreeTraversalData {
    private BinarySearchTreeTraversalData() {
    }

    static BinarySearchTree<Integer> singleElementTree() {
        return new DefaultBinarySearchTree<>(5);
    }

    static BinarySearchTree<Integer> twoDepthTree() {
        BinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(5);
        tree.insert(4);
        tree.insert(6);

        return tree;
    }

    static BinarySearchTree<Integer> threeDepthTree() {
        BinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(5);
        //left subtree
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);

        //right subtree
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);

        return tree;
    }

    static BinarySearchTree<Integer> fourDepthThree() {
        BinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(10);
        //left subtree
        tree.insert(6);
        tree.insert(4);
        tree.insert(3);
        tree.insert(5);
        tree.insert(8);
        tree.insert(7);
        tree.insert(9);

        //right subtree
        tree.insert(14);
        tree.insert(12);
        tree.insert(11);
        tree.insert(13);
        tree.insert(16);
        tree.insert(15);
        tree.insert(17);

        return tree;
    }

    static BinarySearchTree<Integer> treeDegeneratedToLinkedList() {
        BinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(3);
        IntStream.rangeClosed(4, 17).forEach(tree::insert);

        return tree;
    }

    static BinarySearchTree<Integer> notFullAndNotCompleteFourDepthBinaryTree() {
        BinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(10);
        //left subtree
        tree.insert(6);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(5);
        tree.insert(8);
        tree.insert(7);
        tree.insert(9);

        //right subtree
        tree.insert(14);
        tree.insert(12);
        tree.insert(11);
        tree.insert(13);
        tree.insert(16);
        tree.insert(15);
        tree.insert(17);

        return tree;
    }
}
