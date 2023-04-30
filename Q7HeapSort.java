package cw;

import java.util.*;

public class Q7HeapSort {
  
  public static void main(String[] args) {
    int[] arr = {4, 1, 3, 9, 7, 55, 75};
    heapsort(arr);
    System.out.println(Arrays.toString(arr));
  }
  
  public static void heapsort(int[] arr) {
    int n = arr.length;

    for (int i = n/2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    for (int i = n-1; i >= 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, i, 0);
    }
  }

  private static void heapify(int[] arr, int n, int i) {
    int smallest = i;
    int left = 2*i + 1;
    int right = 2*i + 2;

    if (left < n && arr[left] < arr[smallest]) {
      smallest = left;
    }
    if (right < n && arr[right] < arr[smallest]) {
      smallest = right;
    }

    if (smallest != i) {
      int temp = arr[i];
      arr[i] = arr[smallest];
      arr[smallest] = temp;

      heapify(arr, n, smallest);
    }
  }
}
