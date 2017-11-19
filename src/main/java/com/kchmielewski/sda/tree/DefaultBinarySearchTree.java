package com.kchmielewski.sda.tree;

import java.util.Optional;

public class DefaultBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {
    private final T value;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    public DefaultBinarySearchTree(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        this.value = value;
    }

    @Override
    public T value() {
        return value;
    }

    @Override
    public void insert(T value) {
        int comparisonResult = value.compareTo(this.value);
        if (comparisonResult == 0) {
            throw new IllegalArgumentException("Trying to insert already existing value " + value);
        }
        if (comparisonResult < 0) {
            if (left == null) {
                left = new DefaultBinarySearchTree<>(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new DefaultBinarySearchTree<>(value);
            } else {
                right.insert(value);
            }
        }
    }

    @Override
    public Optional<BinarySearchTree<T>> left() {
        return Optional.ofNullable(left);
    }

    @Override
    public Optional<BinarySearchTree<T>> right() {
        return Optional.ofNullable(right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DefaultBinarySearchTree<?> that = (DefaultBinarySearchTree<?>) o;

        if (!value.equals(that.value)) return false;
        if (left != null ? !left.equals(that.left) : that.left != null) return false;
        return right != null ? right.equals(that.right) : that.right == null;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }
}
