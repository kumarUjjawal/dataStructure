
public class QuickSort {

    public static void swap(int[] arr,int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr,int start,int end) {

    // Pivot Point
        int pivot = arr[(start+end)/2];

        while (start <= end) {
    // Until gone through the whole array, find element on left that should be on right.
            while (arr[start] < pivot) {
                start++;
            }
    // Find element on right that should be on left.
            while (arr[end] > pivot) {
                end--;
            }
    // Swap element and move left and right
            if (start <= end) {
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void quickSort(int[] arr, int start,int end) {
        int index = partition(arr,start,end);

        // Sort left half
        if (start < index - 1) {
            quickSort(arr,start,index-1);
        }

        // Sort right half
        if (index < end) {
            quickSort(arr,index,end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,6,2,1,5,9};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i<=arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



}
