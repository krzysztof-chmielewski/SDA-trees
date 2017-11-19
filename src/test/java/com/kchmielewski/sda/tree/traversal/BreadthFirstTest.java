package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class BreadthFirstTest {

    private final BinarySearchTreeTraversal treeTraversal = new BreadthFirst();

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
    public void forThreeLevelDepthReturnsRootThenItsChildrenThenTheirChildren() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.threeDepthTree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(5, 3, 7, 2, 4, 6, 8);
    }

    @Test
    public void forFourLevelDepthReturnsRootThenItsChildrenThenTheirChildren() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.fourDepthThree();

        assertThat(treeTraversal.traverse(tree)).containsExactly(10, 6, 14, 4, 8, 12, 16, 3, 5, 7, 9, 11, 13, 15, 17);
    }

    @Test
    public void treeDegeneratedToLinkedListStaysTheSame() throws Exception {
        BinarySearchTree<Integer> tree = BinarySearchTreeTraversalData.treeDegeneratedToLinkedList();

        assertThat(treeTraversal.traverse(tree)).containsExactly(3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
    }
}