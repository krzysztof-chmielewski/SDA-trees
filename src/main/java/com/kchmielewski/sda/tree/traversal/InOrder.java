package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class InOrder implements BinarySearchTreeTraversal {
    @Override
    public <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree) {
        List<T> result = new ArrayList<>();
        tree.left().ifPresent(t -> result.addAll(traverse(t)));
        result.add(tree.value());
        tree.right().ifPresent(t -> result.addAll(traverse(t)));

        return result;
    }
}
