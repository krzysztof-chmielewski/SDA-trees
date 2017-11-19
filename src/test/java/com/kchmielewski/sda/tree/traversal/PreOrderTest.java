package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;
import com.kchmielewski.sda.tree.DefaultBinarySearchTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class PreOrderTest {
    private final BinarySearchTreeTraversal treeTraversal = new PreOrder();

    @Test
    public void forOneElementTreeReturnsOneElementList() throws Exception {
        BinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(5);
        assertThat(treeTraversal.traverse(tree)).containsExactly(5);
    }

    @Test
    public void forTreeWithBothChildrenReturnsRootThenLeftSubtreeThenRightSubtree() throws Exception {
        BinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(5);
        tree.insert(4);
        tree.insert(6);

        assertThat(treeTraversal.traverse(tree)).containsExactly(5, 4, 6);
    }

    @Test
    public void forThreeLevelDepthTreeReturnsRootThenLeftSubtreeThenRightSubtree() throws Exception {
        BinarySearchTree<Integer> tree = new DefaultBinarySearchTree<>(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);

        assertThat(treeTraversal.traverse(tree)).containsExactly(5, 3, 2, 4, 7, 6, 8);
    }
}