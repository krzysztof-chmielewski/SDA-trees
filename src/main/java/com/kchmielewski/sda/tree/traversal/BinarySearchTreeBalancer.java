package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;

public interface BinarySearchTreeBalancer {
    <V extends Comparable<V>> BinarySearchTree<V> balance(BinarySearchTree<V> tree);
}
