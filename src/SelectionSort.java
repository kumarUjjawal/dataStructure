public class SelectionSort {

    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) {
            int min = i;
             for (int j = i+1; j<n; j++) {
                 if (arr[j] < arr[min]) {
                     min = j;
                 }
             }

             int tmp = arr[i];
             arr[i] = arr[min];
             arr[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,9,4,1,6};
        selectionSort(arr,arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
