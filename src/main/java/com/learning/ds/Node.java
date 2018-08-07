package com.learning.ds;

/**
 * Created by mshaik on 7/24/18.
 */
public class Node<T> {

  T value;
  Node<T> next;

  public Node(T value , Node next) {
    this.value = value;
    this.next = next;
  }

}
