package com.apple.codingTest;

import com.learning.ds.StackWithArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Created by mshaik on 7/16/18.
 */
public class AppleTest {

  public static int MAX_CHAR = 256;
  public static void main(String args[]){

    int[] a = {-1,-1,1} ;
    int target = 0;
   // Arrays.stream(twoSum(a,target)).forEach(System.out::println);
  //  Arrays.stream(sumSubArray()).forEach(System.out::println);
    /*int[] a = {1,3,7,7,9,13};
    int[] b = {12,4,6,17,1,10,13};
    int[] finaList = new int[a.length+b.length];
    Arrays.stream(mergeSort(b)).forEach(System.out::println);*/
   // subArraySum(a,6,0);
   // copyRange();
   // lengthOfLongestSubString("pwwkew");
  //  subarraySum1(a,3);
    int[] i = {20,4,7,6,5,13,21,9};
    StackWithArray stack = new StackWithArray();
    for (int numer : i ){
      stack.push(numer);
    }
    System.out.println(stack.peek());

    while(!stack.isStackEmpty()){
      System.out.println(stack.pop());
    }
    findNextGraterElement(i);
  }


  public static void maxSumSubArray(int a[]) {

    int n = a.length;
    int start=0 , end=0 , s =0;

    int max_sum = a[0];
    int maxEnding = 0;

    for(int i=0 ; i<n ;i++) {

      maxEnding = maxEnding + a[i];

      if(max_sum < maxEnding) {
        max_sum = maxEnding;
        start = s ; end = i;
      }

      if(maxEnding < 0) {
        s = i+1;
        maxEnding = 0;
      }

    }

    System.out.println(start + "ending" + end);

  }




  public static void subarraySum1(int[] nums, int k) {
    int count = 0;
    for (int start = 0; start < nums.length; start++) {
      int sum=0;
      for (int end = start; end < nums.length; end++) {
        sum+=nums[end];
        if (sum == k)
          count++;
      }
    }
    System.out.println(count);
  }

  public static void lengthOfLongestSubString(String s){

   Set<Character> letterSet = new LinkedHashSet<>(s.length());
   int i=0, j=0 , longestLength=0;
   StringBuilder sb = new StringBuilder();
   while(i < s.length() && j<s.length()){

     if(!letterSet.contains(s.charAt(j))){
       letterSet.add(s.charAt(j));
       j++;
       longestLength = Math.max(longestLength,j-i);
       sb.append(s.charAt(j));

     }else {
       letterSet.remove(s.charAt(i));

     }


   }

    System.out.println("Lonest length " + longestLength);
  //  System.out.println(s.substring(i,j+1));

  }

  public static int[] twoSum(int[] nums , int target) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }

    return null;

  }

  private static int[] mergeSort(int[] list){

    int n = list.length;
    if(n < 2) return list;
    int m = n/2;

    int[] left = new int[m];
    int[] right = new int[n-m];

    for(int i= 0 ; i<m ; i++) {
      left[i] = list[i];
    }

    for(int j= m ; j<n ; j++ ){
      right[j-m] = list[j];
    }

    mergeSort(left);
    mergeSort(right);

    return mergeTwoSortedLists(left,right,list);

  }


  public static void sumSubArrayMine(){

    int[] a = { 2, -3, -4, -1, 6 };
    int n = a.length;
    int sum = 2;

    int currentSum = 0;

    Map<Integer,Integer> sumMap = new HashMap<>();

    for(int i=0; i<n ; i++) {

      Integer oldIndex = sumMap.get(currentSum-sum);
      if(oldIndex == null) {
        sumMap.put(currentSum,i);
        currentSum = currentSum+a[i];
      }

      else{
        Arrays.stream(Arrays.copyOfRange(a,oldIndex,i)).forEach(System.out::println);
        return;
      }


    }

    System.out.println("None exist");


  }

  public static String reverseWords(String s1){

    String[] words = s1.split("\\.");

    StringBuilder sb = new StringBuilder(s1.length());

    for(int i=words.length-1 ; i>=0 ; i--) {
      if(i==0){
        sb.append(words[i]);
      }
      else{
        sb.append(words[i]).append(".");
      }
    }
    return sb.toString();

  }

  public static String mergeString(String completeString){

    String[] strings = completeString.split(" ");
    String s1="";
    String s2="";
    if(strings.length>1) {
       s1 = strings[0];
       s2 = strings[1];
    }else {
      s1=strings[0];
    }

    if(s1.length()==0|| s2.length()==0){
      return s1+s2;
    }

    int s1Length = s1.length();
    int s2Length = s2.length();

    StringBuilder sb = new StringBuilder(s1Length+s2Length);

    String s="";

    if(s1!=s2){

       s = s1Length<s2Length?s2.substring(s1Length):s1.substring(s2Length);

    }

    for(int i=0; i<(s1Length<s2Length?s1Length:s2Length); i++) {
      sb.append(s1.charAt(i)).append(s2.charAt(i));
    }

    sb.append(s);

    return sb.toString();

  }

  private static int nonRepeatOfNth(String str , int k) {

    {

      int n = str.length();

      // count[x] is going to store count of
      // character 'x' in str. If x is not present,
      // then it is going to store 0.
      int[] count = new int[MAX_CHAR];

      // index[x] is going to store index of character
      // 'x' in str.  If x is not  present or x is
      // repeating, then it is going to store  a value
      // (for example, length of string) that cannot be
      // a valid index in str[]
      int[] index = new int[MAX_CHAR];

      // Initialize counts of all characters and indexes
      // of non-repeating  characters.
      for (int i = 0; i < MAX_CHAR; i++) {
        count[i] = 0;
        index[i] = n;  // A value more than any index
        // in str[]
      }

      // Traverse the input string
      for (int i = 0; i < n; i++) {
        // Find current character and increment its
        // count
        char x = str.charAt(i);
        ++count[x];

        // If this is first occurrence, then set value
        // in index as index of it.
        if (count[x] == 1)
          index[x] = i;

        // If character repeats, then remove it from
        // index[]
        if (count[x] == 2)
          index[x] = n;
      }

      // Sort index[] in increasing order.  This step
      // takes O(1) time as size of index is 256 only
      Arrays.sort(index);

      // After sorting, if index[k-1] is value, then
      // return it, else return -1.
      return (index[k - 1] != n) ? index[k - 1] : -1;
    }
  }

  private static Character nonRepeat(String s,int n){

    char[]  characters = s.toCharArray();

    Set<Character> charSet = new LinkedHashSet<>(s.length());

    for(Character letter : characters){
      if(charSet.add(letter)){
        charSet.add(letter);
      }else {
        charSet.remove(letter);
      }
    }

   if(!charSet.isEmpty()) {
      int count = 1;
      for(Character c : charSet){
        if(count == n){
          return c;
        }
        count ++;
      }


   }

    return null;
  }


  private static Character nthChar(String decoded , int n){

    StringBuilder encodedString = new StringBuilder();

    String temp = "";
    int freq = 0;
    for(int i=0 ; i<decoded.length();) {

      temp = "";
      freq = 0;

      while(i<decoded.length()&&decoded.charAt(i)>='a'&&decoded.charAt(i)<='z'){
        temp = temp + decoded.charAt(i);
        i++;
      }

      while (i<decoded.length()&&decoded.charAt(i)>='1' && decoded.charAt(i)<='9'){

        freq = 10*freq + decoded.charAt(i);
        i++;

      }

      for(int j=1; j<=freq ; j++){
        encodedString.append(temp);
      }

      if(freq==0){
        encodedString.append(temp);
      }

    }

    return encodedString.charAt(n-1);

  }

  static char encodedChar(String str,int k)
  {
    // expand string variable is used to
    // store final string after decompressing
    // string str
    String expand = "";

    String temp = "";  // Current substring
    int freq = 0; // Count of current substring

    for (int i=0; i < str.length() ; )
    {
      temp = ""; // Current substring
      freq = 0; // count frequency of current
      // substring

      // read characters until you find a number
      // or end of string
      while (i < str.length() && str.charAt(i)>='a'
          && str.charAt(i)<='z')
      {
        // push character in temp
        temp += str.charAt(i);
        i++;
      }

      // read number for how many times string temp
      // will be repeated in decompressed string
      while (i < str.length() && str.charAt(i)>='1'
          && str.charAt(i)<='9')
      {
        // generating frequency of temp
        freq = freq*10 + str.charAt(i) - '0';
        i++;
      }

      // now append string temp into expand
      // equal to its frequency
      for (int j=1; j<=freq; j++)
        expand += temp;
    }

    // this condition is to handle the case
    // when string str is ended with alphabets
    // not with numeric value
    if (freq==0)
      expand += temp;

    return expand.charAt(k-1);
  }


  private static void copyRange(){

    int[] a = {1,2,-5,1,2,-1};

    Arrays.stream(Arrays.copyOfRange(a, 0, 4)).forEach(System.out::println);


  }

  static int subArraySum(int arr[], int n, int sum)
  {
    int curr_sum = arr[0], start = 0, i;

    // Pick a starting point
    for (i = 1; i <= n; i++)
    {
      // If curr_sum exceeds the sum, then remove the starting elements
      while (curr_sum > sum && start < i-1)
      {
        curr_sum = curr_sum - arr[start];
        start++;
      }

      // If curr_sum becomes equal to sum, then return true
      if (curr_sum == sum)
      {
        int p = i-1;
        System.out.println("Sum found between indexes " + start
            + " and " + p);
        return 1;
      }

      // Add this element to curr_sum
      if (i < n)
        curr_sum = curr_sum + arr[i];

    }

    System.out.println("No subarray found");
    return 0;
  }

  private static void subArrayLoop() {

    int[] a = {1,2,-5,1,2,-1};
    int sum=1;

    for(int i=0 ; i<a.length ; i++) {

      int find = a[i];

      for(int j=i+1; j<=a.length ; j++){

        if(find == sum) {
          Arrays.stream(Arrays.copyOfRange(a, i, j)).forEach(System.out::println);
          return ;
        }

        if(find > sum || j==a.length) {
          break;
        }
          find = find + a[j];

      }


    }



  }

  private static int[] sumSubArray(){

   int[] a = {1,2,-5,1,2,-1};
    int sum=2;

    Map<Integer,Integer> map = new HashMap<>();

    for(int i=0; i<a.length ; i++){

      Integer oldIndex = map.get(sum);

      if(oldIndex==null) {

         map.put(sum,i);
         sum = sum + a[i];

      }else {
        return Arrays.copyOfRange(a,oldIndex,i);
      }



    }


    return null;
  }


  private static int[] mergeTwoSortedLists(int[] list1 , int[] list2 , int[] finaList ){

    int list1Length = list1.length;
    int list2Length = list2.length;
    int i=0 , j=0 , k=0;

    while(i<list1Length && j<list2Length) {

      if(list1[i] < list2[j]){
        finaList[k] = list1[i];
        i++;
      }else {
        finaList[k] = list2[j];
        j++;
      }

      k++;
    }

    while(i < list1Length) {
      finaList[k] = list1[i];
      i++;
      k++;
    }

    while (j<list2Length) {

      finaList[k] = list2[j];
      j++;
      k++;

    }

   return finaList;

  }




  private static void stackUsingQueue(){

    Queue<Integer> stack = new LinkedList<>();

  }

  public static int subarraySum(int[] nums, int k) {
    int count = 0;
    int[] sum = new int[nums.length + 1];
    sum[0] = 0;
    for (int i = 1; i <= nums.length; i++)
      sum[i] = sum[i - 1] + nums[i - 1];
    for (int start = 0; start < nums.length; start++) {
      for (int end = start + 1; end <= nums.length; end++) {
        if (sum[end] - sum[start] == k)
          count++;
      }
    }
    return count;
  }


  private static void findNextGraterElement(int[] array){

    Stack<Integer> elements = new Stack<>();
    Map<Integer,Integer> map = new LinkedHashMap<>(array.length);
    for(int i : array){
      if(!elements.empty()) {
        while(!elements.empty()&&elements.peek() < i){
          map.put(elements.pop(),i);
        }

      }
      elements.push(i);

    }

    map.entrySet().forEach(entry->{
      System.out.println(entry.getKey()+ " " + entry.getValue());
    });


  }


  public void rodCuttingStrategy(int length, int[] prices) {






  }

}
