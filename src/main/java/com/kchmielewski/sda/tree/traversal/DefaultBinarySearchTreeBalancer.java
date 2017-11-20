package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;
import com.kchmielewski.sda.tree.DefaultBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class DefaultBinarySearchTreeBalancer implements BinarySearchTreeBalancer {
    @Override
    public <V extends Comparable<V>> BinarySearchTree<V> balance(BinarySearchTree<V> tree) {
        List<V> values = new ArrayList<>(new InOrder().traverse(tree));
        int rootIndex = values.size() / 2;
        BinarySearchTree<V> result = new DefaultBinarySearchTree<>(values.get(rootIndex));
        if (rootIndex >= 1) {
            fill(result, values.subList(0, rootIndex));
        }
        if (rootIndex < values.size() - 1) {
            fill(result, values.subList(rootIndex + 1, values.size()));
        }

        return result;
    }

    private <V extends Comparable<V>> void fill(BinarySearchTree<V> root, List<V> sublist) {
        if (sublist.size() == 1) {
            root.insert(sublist.get(0));
        } else if (sublist.size() == 2) {
            root.insert(sublist.get(1));
            root.insert(sublist.get(0));
        } else {
            int rootIndex = sublist.size() / 2;
            root.insert(sublist.get(rootIndex));
            if (rootIndex >= 1) {
                fill(root, sublist.subList(0, rootIndex));
            }
            if (rootIndex <= sublist.size() - 1) {
                fill(root, sublist.subList(rootIndex + 1, sublist.size()));
            }
        }
    }
}
