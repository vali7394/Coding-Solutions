package com.learning.ds.trees;

/**
 * Created by mshaik on 8/5/18.
 */
public class TestBst {

  public static void main(String args[]) {
    BSTSample bst = new BSTSample();
    bst.addNode(17);
    bst.addNode(24);
    bst.addNode(6);
    bst.addNode(7);
    bst.addNode(9);
    bst.addNode(10);
    bst.addNode(14);
    bst.addNode(30);
    bst.addNode(1);
    bst.addNode(14);
    System.out.println(bst.findANode(11));
    System.out.println(bst.findMin());
    System.out.println(bst.findMax());
    System.out.println(bst.height());

  }
}
