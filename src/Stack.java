import java.util.Arrays;

public class Stack {

    private Object[] contents; // Object array to hold the contents of the array

    private int size; // current size of the stack

    private int topOfStack = -1; // current index

    // Creating a new stack
    Stack(int size) {
        this.size = size; // set the size
        contents = new Object[size];
        Arrays.fill(contents,"-1"); //
    }

    public void push(Object o) {
        if (topOfStack+1 < size) {
            topOfStack++;
            contents[topOfStack] = o;
            System.out.println("Input " + o + " " + "inserted into the stack.");
        } else {
            System.out.println("Stack Full, Unable to push.");
        }
    }

    public Object pop() {
        if (topOfStack >= 0) {
            System.out.println("Item " + contents[topOfStack] + " " +"removed.");
            contents[topOfStack] = "-1";
            return contents[topOfStack--];
        } else {
            System.out.println("Stack is empty.");
            return "-1";
        }
    }

    public void pushMultiple(Object[] o) {
        for (int i = 0; i<o.length; i++) {
            push(o[i]);
        }
    }

    public void empty() {
        if (topOfStack >= 0) {
            for (int i = topOfStack; i>0; i--) {
                pop();
            }
            System.out.println("Stack empty, Successful");
        } else {
            System.out.println("Stack is already empty.");
        }
    }

    public void display() {
        // Determine the max width for the index column
        int index = 0;
        for (int i = 0; i<size; i++) {
            int lenght = String.valueOf(i).length();
            if (lenght > index) {
                index = lenght;
            }
        }

        // Determine the max width for the data column

        int data = 0;
        for (int i = 0; i < size; i++) {
            int length = contents[i].toString().length();
            if (length > data) {
                data = length;
            }
        }

        // Format the top line in the stack
        System.out.print(" _____");
        for(int i = 0; i < index; i++) System.out.print("_");
        for(int i = 0; i < data; i++) System.out.print("_");
        System.out.println();

        // Create format specifiers for the index width and data width
        String index_width = "%-" + index + "s";
        String data_width = "%-" + data + "s";

        for(int i = size-1; i >= 0; i--) {

            if (contents[i] != "-1") { // If an object exists, output the data
                System.out.printf("| " + index_width + " | " + data_width +" |\n", i, contents[i]);

            } else { // Output just the index and a blank space
                System.out.printf("| " + index_width + " | " + data_width +" |\n", i, "");

            }
        }
        // Format the bottom line in the stack
        System.out.print("|__");
        for(int i = 0; i < index; i++) System.out.print("_");

        System.out.print("|__");
        for(int i = 0; i < data; i++) System.out.print("_");

        System.out.println("|\n");

    }


    public static void main(String[] args) {
        Stack stack = new Stack(6);

        stack.push(20);
        stack.push("Kumar Ujjawal");
        stack.push("BCA");
        stack.pushMultiple(new Object[]{20,"Ujjawal",124});

        stack.display();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();

        // Create Object array and push the item

        Object[] o = {"Hello",20,124,"Ujjawal"};
        stack.pushMultiple(o);
        stack.display();


    }
}
