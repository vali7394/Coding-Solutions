package com.com.sorting.algorthims;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mshaik on 8/6/18.
 */
public class TestSelectionSort {


  public static void main(String args[]) {

    int[] numbers = {4,2,7,5,6,1,14};

    IntStream.of(numbers).forEach(no->System.out.println(no));

    selectionSort(numbers);

    IntStream.of(numbers).forEach(no->System.out.println(no));

  }

  private static void selectionSort(int[] numbers) {

    int[] number1 = numbers;

    for(int i=0 ; i< number1.length-2 ; i++) {

      int min = i;

      for(int j=i+1; j<number1.length-1 ; j++){

        if(number1[j] < number1[min]) {
          min = j;
        }

      }

      int temp = number1[i];
      number1[i] = number1[min];
      number1[min] = temp;

    }

    IntStream.of(numbers).forEach(no->System.out.println(no));

  }

}
