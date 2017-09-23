public class MergeSort {

    public static void merge(int[] left,int[] right, int[] arr) {

        int i = 0, j = 0, k = 0;

        // i - index of left sub-array
        // j - index of right sub-array
        // k - index of merged sub-array

        int nL = left.length;
        int nR = right.length;

        while (i < nL && j < nR) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        while (i <nL) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < nR) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    public static void mergeSort(int[] arr, int n) {
        int i;

        // If the array has less than two elements, do nothing.
        if (n < 2) return;
        // Find the middle index
        int mid = (n/2);

        int[] left = new int[mid];
        int[] right = new int[n-mid];

        // Creating left sub-array
        for (i = 0; i<mid; i++) {
            left[i] = arr[i];
        }
        // Creating right sub-array
        for (i = mid; i< n; i++) {
            right[i-mid] = arr[i];
        }

        mergeSort(left,mid);
        mergeSort(right,n-mid);
        merge(left,right,arr);


    }

    public static void main(String[] args) {
        int[] arr = {8,2,4,1,9,7};

        mergeSort(arr,arr.length);

        for (int i = 0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
