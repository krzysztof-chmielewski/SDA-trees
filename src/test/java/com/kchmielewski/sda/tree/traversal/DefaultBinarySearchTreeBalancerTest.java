package com.kchmielewski.sda.tree.traversal;

import com.kchmielewski.sda.tree.BinarySearchTree;
import com.kchmielewski.sda.tree.DefaultBinarySearchTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(BlockJUnit4ClassRunner.class)
public class DefaultBinarySearchTreeBalancerTest {
    private final BinarySearchTreeBalancer balancer = new DefaultBinarySearchTreeBalancer();

    @Test
    public void forSingleElementTreeReturnsSingleElementTree() throws Exception {
        BinarySearchTree<Integer> result = balancer.balance(BinarySearchTreeTraversalData.singleElementTree());
        BinarySearchTree<Integer> expected = new DefaultBinarySearchTree<>(5);

        assertThat(result).containsExactlyElementsOf(expected);
    }

    @Test
    public void forTwoDepthBalancedTreeReturnsSameThree() throws Exception {
        BinarySearchTree<Integer> result = balancer.balance(BinarySearchTreeTraversalData.twoDepthTree());
        BinarySearchTree<Integer> expected = BinarySearchTreeTraversalData.twoDepthTree();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void forThreeDegeneratedToLinkedListReturnsBalancedTree() throws Exception {
        BinarySearchTree<Integer> result = balancer.balance(BinarySearchTreeTraversalData.treeDegeneratedToLinkedList());
        BinarySearchTree<Integer> expected = BinarySearchTreeTraversalData.fourDepthThree();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void notFullAndNotCompleteBinaryTreeIsComplete() throws Exception {
        BinarySearchTree<Integer> result = balancer.balance(BinarySearchTreeTraversalData.notFullAndNotCompleteFourDepthBinaryTree());
        BinarySearchTree<Integer> expected = BinarySearchTreeTraversalData.fourDepthThree();
        expected.insert(2);

        assertThat(result).isEqualTo(expected);
    }
}