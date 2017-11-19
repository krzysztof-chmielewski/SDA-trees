package com.kchmielewski.sda.tree;

public interface BinarySearchTree<T extends Comparable<T>> extends BinaryTree<BinarySearchTree<T>, T>, Iterable<T> {
}
