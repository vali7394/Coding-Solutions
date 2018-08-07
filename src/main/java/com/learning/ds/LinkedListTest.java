package com.learning.ds;

import java.util.LinkedList;

/**
 * Created by mshaik on 7/24/18.
 */
public class LinkedListTest<T> {

  public LinkedListTest(){

  }

  Node<T> head;


  public Node<T> addFirst(T value){

    if(head == null) {
      head = new Node(value,null);
    } else {
      head = new Node(value,head);
    }

    return head;
  }

  public Node<T> addLast(T value) {

    if(head == null) return addFirst(value);
    else {

      Node temp = head;

      while(temp.next!=null){
        temp = temp.next;
      }
      temp.next = new Node(value,null);
      return head;
    }


  }


  public Node<T> insertInMiddle(T value,int position){

    int count=1;
    Node temp = head;
    Node next = null;

    while(temp!=null) {
      next = temp.next;
      if(count == position){
        temp = new Node(value,next);
      }
    }
    return head;
  }

  public Node<T> deleteANode(T value , int position){

    if(position == 1) {
      head = head.next;
      return head;
    }

      int count =1;
      Node temp = head;
      Node next = null;
      Node prev = null;

      while(temp!=null){
        next = temp.next;
        if(count == position){
          prev.next = next;
        }
        prev = temp;
        temp = next;
      }

      return head;
  }

  public Node<T> deleteFromRear(T value , int position) {

    Node fast = head;
    Node slow = head;

    for(int n=0 ; n<position-1 ; n++){
      fast = fast.next;
    }

    if(fast == null) {
      System.out.println("Invalid Position");
      return head;
    }

    Node prev = null;
    Node next = null;

    while(fast!=null){
      next = slow.next;
      prev = slow;
      slow = next;
    }

    prev.next = next;
    return head;
  }

}
