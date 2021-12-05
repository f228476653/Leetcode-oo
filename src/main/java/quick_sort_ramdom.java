import java.util.*;

public class quick_sort_ramdom {
    // This Function helps in calculating
    // random numbers between low(inclusive)
    // and high(inclusive)
    static void random(int arr[],int low,int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;
        int temp =arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp;
    }

    /* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
    static void partition(int[] arr, int low, int high)
    {
        int count=0;
       for(int i = low; i <= high-1; i++){
           if (arr[i]> arr[high]){
               count++;
               int temp = arr[i];
               arr[i] = arr[high-count];
               arr[high-count] = temp;
           }else{

           }
       }
    }


    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low --> Starting index,
    high --> Ending index */
    static void sort(int arr[], int low, int high)
    {
        if(low<high){
            random(arr,low, high);

        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver Code
    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        sort(arr, 0, n-1);

        System.out.println("Sorted array");
        printArray(arr);
    }
}