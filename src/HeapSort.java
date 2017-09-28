import java.util.Arrays;

public class HeapSort {

    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) { return (2 * parentIndex) + 1; }

    private int getRightChildIndex(int parentIndex) { return (2 * parentIndex) + 2; }

    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }

    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }

    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }

    private int rightChild(int index) { return items[getRightChildIndex(index)]; }

    private int parent(int index) { return items[getParentIndex(index)]; }

    private void swap(int indexOne, int indexTwo) {
        int tmp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = tmp;
    }

    //Checks if the array is full if so creates a new array double that size and copy the array.
    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    // It checks if the array is empty if so throws an exception, Otherwise it just returns the first element in the array.

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    // It will extract the minimum element and removes it from array.
    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1]; // move the last element to the first element
        size--; // Shrink array
        heapifyDown();
        return item;
    }

    // Add en element
    public void add(int item) {
        ensureExtraCapacity();
        items[size] =  item; // add item to the very last
        size++;
        heapifyUP();
    }


    public void heapifyDown() {
        int index = 0;
        // Walk up as long as there is children.
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index,smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    public void heapifyUP() {
        int index = size - 1; // Last item add
        // walk up as long as there is a parent item and parent index is bigger than item index.
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }



}













