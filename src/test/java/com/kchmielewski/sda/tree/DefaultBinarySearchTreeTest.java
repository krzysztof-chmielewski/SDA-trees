package com.kchmielewski.sda.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(BlockJUnit4ClassRunner.class)
public class DefaultBinarySearchTreeTest {
    @Test
    public void cannotCreateTreeWithoutValue() throws Exception {
        assertThatThrownBy(() -> new DefaultBinarySearchTree<Integer>(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void cannotCreateTreeWithoutIterator() throws Exception {
        assertThatThrownBy(() -> new DefaultBinarySearchTree<>(5, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void cannotInsertAlreadyExistingValue() throws Exception {
        assertThatThrownBy(() -> new DefaultBinarySearchTree<>(8).insert(8)).isInstanceOf(IllegalArgumentException.class);
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

    @Test
    public void iteratorReturnsInOrderByDefault() throws Exception {
        DefaultBinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(8);
        tree.insert(7);
        tree.insert(9);

        List<Integer> result = new ArrayList<>(3);
        tree.iterator().forEachRemaining(result::add);

        assertThat(result).containsExactly(7, 8, 9);
    }

    @Test
    public void findForNullThrowsException() throws Exception {
        assertThatThrownBy(() -> new DefaultBinarySearchTree<>(5).find(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void findForNonExisintValueReturnsEmptyOptional() throws Exception {
        assertThat(new DefaultBinarySearchTree<>(5).find(1)).isEqualTo(Optional.empty());
    }

    @Test
    public void findForRootValueReturnsItsValue() throws Exception {
        assertThat(new DefaultBinarySearchTree<>(5).find(5)).isEqualTo(Optional.of(5));
    }

    @Test
    public void findForLowerValueGoesToLeftSubtree() throws Exception {
        DefaultBinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(5);
        tree.insert(4);
        tree.insert(6);

        assertThat(tree.find(4)).isEqualTo(Optional.of(4));
    }

    @Test
    public void findForLowerValueGoesToRightSubtree() throws Exception {
        DefaultBinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(5);
        tree.insert(4);
        tree.insert(6);

        assertThat(tree.find(6)).isEqualTo(Optional.of(6));
    }
}