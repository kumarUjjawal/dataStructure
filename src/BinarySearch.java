public class BinarySearch {

    public static int binarySearch(int[] a,int element) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) /2;
            if (a[mid] < element) {
                low = mid + 1;
            } else if (a[mid] > element) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
