package com.com.sorting.algorthims;

import java.util.stream.IntStream;

/**
 * Created by mshaik on 8/6/18.
 */
public class TestBubbleSort {

  public static void main(String args[]){

    int[] numbers = {4,2,7,5,6,1,14};
    IntStream.of(numbers).forEach(System.out::println);
    bubbleSort(numbers);

  }

  private static void bubbleSort(int[] numbers) {
    int length = numbers.length;
    for(int i=0 ; i< length-1 ; i++) {
      int flag = 0;
      for(int j=0 ; j<length-i-1 ; j++) {

        if(numbers[j] > numbers[j+1]) {

          int temp = numbers[j];
          numbers[j] = numbers[j+1];
          numbers[j+1] = temp;
          flag = 1;

        }

      }

      if(flag==0) break;


    }

    IntStream.of(numbers).forEach(System.out::println);

  }

}
