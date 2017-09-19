public class SimpleBubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int tmp = 0;

        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=(n-1); j++) {
                if (arr[j-1] > arr[j]) {
                    // Swap
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {32,12,9,42,4};

        System.out.println("Elements before sorting");
        for (int i = 0; i<arr.length; i++) {
            System.out.println(arr[i]+ " ");
        }

        bubbleSort(arr);

        System.out.println("Elements after sorting");
        for (int i = 0; i<arr.length; i++) {
            System.out.println(arr[i]+ " ");
        }
    }
}
