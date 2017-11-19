package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class PostOrderTest {
    private final BinarySearchTreeTraversal treeTraversal = new PostOrder();

    @Test
    public void forOneElementTreeReturnsOneElementList() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.singleElementTree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(5);
    }

    @Test
    public void forTreeWithBothChildrenReturnsLeftSubtreeThenRightSubtreeThenRoot() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.twoDepthTree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(4, 6, 5);
    }

    @Test
    public void forThreeLevelDepthReturnsLeftSubtreeThenRightSubtreeThenRoot() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.threeDepthTree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(2, 4, 3, 6, 8, 7, 5);
    }
}