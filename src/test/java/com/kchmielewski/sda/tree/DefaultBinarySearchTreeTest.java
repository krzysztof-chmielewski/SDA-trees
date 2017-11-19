package com.kchmielewski.sda.tree;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class DefaultBinarySearchTreeTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void cannotCreateTreeWithoutValue() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        new DefaultBinarySearchTree<Integer>(null);
    }

    @Test
    public void cannotInsertAlreadyExistingValue() throws Exception {
        expectedException.expect(IllegalArgumentException.class);

        new DefaultBinarySearchTree<>(8).insert(8);
    }

    @Test
    public void lowerValueIsInsertedAsALeftChild() throws Exception {
        DefaultBinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(8);

        tree.insert(5);

        assertThat(tree.left()).contains(new DefaultBinarySearchTree<>(5));
        assertThat(tree.right()).isEmpty();
    }

    @Test
    public void higherValueIsInsertedAsARightChild() throws Exception {
        DefaultBinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(8);

        tree.insert(12);

        assertThat(tree.right()).contains(new DefaultBinarySearchTree<>(12));
        assertThat(tree.left()).isEmpty();
    }

    @Test
    public void lowerValueIsInsertedIntoLeftSubtree() throws Exception {
        DefaultBinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(8);
        DefaultBinarySearchTree<Integer> leftSubtree = new DefaultBinarySearchTree<>(7);
        leftSubtree.insert(6);

        tree.insert(7);
        tree.insert(6);

        assertThat(tree.left()).contains(leftSubtree);
    }

    @Test
    public void higherValueIsInsertedIntoRightSubtree() throws Exception {
        DefaultBinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(8);
        DefaultBinarySearchTree<Integer> rightSubtree = new DefaultBinarySearchTree<>(10);
        rightSubtree.insert(9);

        tree.insert(10);
        tree.insert(9);

        assertThat(tree.right()).contains(rightSubtree);
    }
}