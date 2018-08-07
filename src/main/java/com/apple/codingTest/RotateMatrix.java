package com.apple.codingTest;

/**
 * Created by mshaik on 7/31/18.
 */

public class RotateMatrix {

  int[][] simpleArray = new int[4][4];


  public void addDate(){
    int count =0;
    for(int i=0 ; i<simpleArray.length; i++) {
      for(int j=0; j<simpleArray[0].length; j++) {
        simpleArray[i][j] = count;
        count ++;
      }

    }



  }

  public void displayData(int[][] simpleArray) {

    for (int i=0; i < simpleArray.length; i++) {

      for(int j=0; j< simpleArray[0].length; j++) {


        System.out.print(simpleArray[i][j] + " ");


      }
       System.out.println();

    }
  }


  public static void main(String args[]) {

    RotateMatrix  rotateMatrix = new RotateMatrix();
    rotateMatrix.addDate();
    rotateMatrix.displayData(rotateMatrix.simpleArray);
    rotateMatrix.rotateMatrix(rotateMatrix.simpleArray);

  }


  public  void rotateMatrix(int[][] matrix) {

    int totalRowsOfRotatedMatrix = matrix[0].length; //Total columns of Original Matrix
    int totalColsOfRotatedMatrix = matrix.length; //Total rows of Original Matrix

    int[][] rotatedMatrix = new int[totalRowsOfRotatedMatrix][totalColsOfRotatedMatrix];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {

        rotatedMatrix[j][(totalColsOfRotatedMatrix-1)-i] = matrix[i][j];
      }
      totalRowsOfRotatedMatrix--;
    }


  displayData(rotatedMatrix);

  }



}
