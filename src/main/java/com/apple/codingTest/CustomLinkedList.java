package com.apple.codingTest;

/**
 * Created by mshaik on 7/19/18.
 */
public class CustomLinkedList<T> {

  Node<T> head;

  public CustomLinkedList() {

  }


  public Node addFirst(T value) {

    if (head == null) head = new Node<>(value, null);
    else {
      head = new Node(value, head);
    }

    return head;
  }


  public Node add(T value) {

    if (head == null) addFirst(value);

    Node temp = head;

    while (temp.next != null) {
      temp = temp.next;
    }

    temp.next = new Node(value, null);
    return head;
  }


  public void insertAtNth(T value, int n) {

    Node temp = head;
    int count = 1;
    Node next = null;
    Node prev = null;
    while (temp.next != null) {
      next = temp.next;
      if (count == n) {
        prev.next = next;
      }

    }

  }

}
