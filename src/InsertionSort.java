
public class InsertionSort {

    public static void insertionSort(int[] arr, int n) {
        for (int i = 1; i<n; i++) {
            int value = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > value) {
                arr[j] = arr[j-1];
                j = j-1;
            }
            arr[j] = value;
        }
    }

    public static void print(int[] arr, int n) {
        System.out.println();
        for (int i = 0; i<n; i++) {
            System.out.println(arr[i]+"\t");
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,2,7,1,8,4};
        insertionSort(arr,arr.length);
        print(arr,arr.length);
    }
}
