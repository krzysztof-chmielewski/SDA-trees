package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class PreOrderTest {
    private final BinarySearchTreeTraversal treeTraversal = new PreOrder();

    @Test
    public void forOneElementTreeReturnsOneElementList() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.singleElementTree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(5);
    }

    @Test
    public void forTreeWithBothChildrenReturnsRootThenLeftSubtreeThenRightSubtree() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.twoDepthTree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(5, 4, 6);
    }

    @Test
    public void forThreeLevelDepthTreeReturnsRootThenLeftSubtreeThenRightSubtree() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.threeDepthTree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(5, 3, 2, 4, 7, 6, 8);
    }
}