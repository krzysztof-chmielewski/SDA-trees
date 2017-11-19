package com.kchmielewski.sda.tree;

import java.util.Optional;

public interface BinaryTree<Tree extends BinaryTree<Tree, Value>, Value> {
    Value value();

    void insert(Value value);

    Optional<Tree> left();

    Optional<Tree> right();
}
