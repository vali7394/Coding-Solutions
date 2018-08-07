package com.learning.ds.trees;

/**
 * Created by mshaik on 8/5/18.
 */
public class BSTSample {

  TreeNode root;

  BSTSample() {
    root = null;
  }

  private TreeNode insertNode(TreeNode root , int data) {

    if(root == null) {
      root = new TreeNode(data,null,null);
      return root;
    }

    if(root.data < data) {
     root.right = insertNode(root.right , data);
    }
    else {
     root.left= insertNode(root.left,data);
    }

    return root;
  }


  public void addNode(int data) {
    root= insertNode(root,data);
  }

  private boolean findAnElementInTree(TreeNode root , int data ) {
    TreeNode temp = root;
    if(temp == null) {
      return false;
    }

    if(temp.data == data) {
      return true;
    }

    if(temp.data < data) {
     return findAnElementInTree(temp.right, data);
    } else {
     return  findAnElementInTree(temp.left,data);
    }

  }

  public boolean findANode(int data){
    return findAnElementInTree(root,data);
  }

  private int findMinInBST(TreeNode root) {

    if(root == null) {
      return -1;
    }

    while(root.left!=null){
      root = root.left;
    }

    return root.data;

  }

  public int findMin(){
    return findMinRec(root);
  }

  private int findMax(TreeNode root){
    if(root == null) {
      return -1;
    }

    while(root.right!=null) {
      root = root.right;
    }
    return root.data;
  }

  public int findMax() {
    return findMax(root);
  }

  public int findMinRec(TreeNode root){

    if(root == null) {
      return -1;
    }

    else if(root.left==null){
      return root.data;
    }

    return findMinRec(root.left);

  }

  public int height(){
    return findHeightOfBST(root);
  }

  private int findHeightOfBST(TreeNode root){

    if(root == null) {
      return -1;
    }

    int lstHeight = findHeightOfBST(root.left);
    int rst = findHeightOfBST(root.right);

    return Math.max(lstHeight,rst)+1;

  }

}
