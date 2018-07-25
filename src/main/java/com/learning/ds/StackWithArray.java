package com.learning.ds;

/**
 * Created by mshaik on 7/24/18.
 */
public class StackWithArray<T> {
  int initialSize = 20 ;
  Integer[] array = new Integer[initialSize];

  int top = -1;


  public StackWithArray() {

  }

  public StackWithArray(int initialSize) {
    this.initialSize = initialSize;
  }


  public void push(int element) {
    if(top == array.length-1){
      System.out.println("Stack over flow");
    }else {
      top++;
      array[top] = element;
    }
  }

  public boolean isStackEmpty(){
    return top == 1 ;
  }

  public int peek() {

    if(isStackEmpty()) {
      System.out.println("Stack is empty");
      return Integer.MIN_VALUE;
    }else {
      return array[top];
    }

  }

  public int pop() {

    if(isStackEmpty()) {
      System.out.println("Stack is empty");
      return Integer.MIN_VALUE;
    }

    else {
      int poped = array[top];
      top --;
      return poped;
    }

  }

}
