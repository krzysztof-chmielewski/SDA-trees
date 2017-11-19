package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirst implements BinarySearchTreeTraversal {
    @Override
    public <T extends Comparable<T>> List<T> traverse(BinarySearchTree<T> tree) {
        Queue<BinarySearchTree<T>> queue = new LinkedList<>();
        List<T> result = new ArrayList<>();

        queue.add(tree);
        while (!queue.isEmpty()) {
            BinarySearchTree<T> currentNode = queue.remove();
            result.add(currentNode.value());
            currentNode.left().ifPresent(queue::add);
            currentNode.right().ifPresent(queue::add);
        }

        return result;
    }
}
