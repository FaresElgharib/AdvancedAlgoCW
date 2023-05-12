package cw;

import java.util.*;

public class Q7HeapSort {
  
  public static void main(String[] args) {
    // Running the code
    int[] arr = {4, 1, 3, 9, 7, 55, 75};
    heapsort(arr);
    System.out.println(Arrays.toString(arr));
  }
  
  public static void heapsort(int[] arr) {
    int n = arr.length;
  
    // Creating the min Heap
    for (int i = n/2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    // Getting the elements from the heap
    for (int i = n-1; i >= 0; i--) {
      // Moving the minimum element to the end
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // Heapifying the remaining elements
      heapify(arr, i, 0);
    }
  }

  private static void heapify(int[] arr, int n, int i) {
    
    int smallest = i; // Root element
    int left = 2*i + 1; // Left child element
    int right = 2*i + 2; // Right child element

    // Checking for the smallest element from root, left child, and right child
    if (left < n && arr[left] < arr[smallest]) {
      smallest = left;
    }
    if (right < n && arr[right] < arr[smallest]) {
      smallest = right;
    }

    // Checking if the "smallest" element is not the root
    if (smallest != i) {
      // Swaping the "smallest" element with the root element
      int temp = arr[i];
      arr[i] = arr[smallest];
      arr[smallest] = temp;

      // Heapifying the subtree recursively
      heapify(arr, n, smallest);
    }
  }
}
