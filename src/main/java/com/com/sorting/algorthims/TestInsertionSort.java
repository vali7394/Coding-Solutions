package com.com.sorting.algorthims;

import java.util.stream.IntStream;

/**
 * Created by mshaik on 8/6/18.
 */
public class TestInsertionSort {

  public static void main(String args[]){

    int[] numbers = {4,2,7,5,6,1,14};
    IntStream.of(numbers).forEach(System.out::println);
    insertionSort(numbers);

  }

  private static void insertionSort(int[] numbers) {

    int length = numbers.length;

    for(int i=1; i<length-1; i++) {

      int temp = numbers[i] ;
      int index = i;

      while(index > 0 && temp < numbers[index-1]) {
        numbers[i] = numbers[index-1];
        index--;
      }

      numbers[index] = temp;

    }




  }


}
