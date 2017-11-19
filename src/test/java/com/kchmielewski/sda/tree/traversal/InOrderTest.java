package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class InOrderTest {
    private final BinarySearchTreeTraversal treeTraversal = new InOrder();

    @Test
    public void forOneElementTreeReturnsOneElementList() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.singleElementTree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(5);
    }

    @Test
    public void forTreeWithBothChildrenReturnsLeftSubtreeThenRootThenRightSubtree() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.twoDepthTree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(4, 5, 6);
    }

    @Test
    public void forThreeLevelDepthTreeReturnsLeftSubtreeRootThenThenRightSubtree() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.threeDepthTree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(2, 3, 4, 5, 6, 7, 8);
    }
}