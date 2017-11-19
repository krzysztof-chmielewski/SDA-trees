package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;

import java.util.List;

public interface BinarySearchTreeTraversal {
    <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree);
}
