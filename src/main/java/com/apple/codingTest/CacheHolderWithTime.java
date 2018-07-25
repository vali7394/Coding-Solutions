package com.apple.codingTest;

import java.util.Scanner;

/**
 * Created by mshaik on 7/16/18.
 */
public class CacheHolderWithTime<T> {

  T value;
  long insertionTime;

  public CacheHolderWithTime(T value , long insertionTime) {

    this.value = value;
    this.insertionTime = insertionTime;

    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();

    for(int i=1 ; i<=a ; i++){
      scanner.nextInt();
    }
  }


  public long getInsertionTime(){
    return insertionTime;
  }



}
