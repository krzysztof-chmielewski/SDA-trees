package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;
import com.kchmielewski.sda.tree.DefaultBinarySearchTree;

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
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);

        return tree;
    }
}
