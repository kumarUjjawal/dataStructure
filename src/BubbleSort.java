import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {

        List<String> list = Arrays.asList(args);

        bubbleSort(list);

        for (String s: list) {
            System.out.println(s);
        }
    }

    public static List<String> bubbleSort(List<String> list) {
        String currentWord,lastWord,tmp;
        boolean swapped = false;
        int wordLenght;

        for (int i = 1; i<=list.size(); i++) {
            currentWord = list.get(i);
            lastWord = list.get(i-1);

            if (checkString(currentWord,lastWord)) {
                swap(list,i,i-1);
                swapped = true;
            }

            if (i >= list.size() - 1) {
                if (!swapped) {
                    break;
                } else {
                    i = 0;
                    swapped = false;
                }
            }

        }
        return list;
    }

    public static void swap(List<String> list,int index0, int index1) {
        String tmp = list.get(index0);
        list.set(index0,list.get(index1));
        list.set(index1,tmp);
    }

    public static boolean checkString(String string0, String string1) {
        int stringLength = string0.length() < string1.length() ? string0.length() : string1.length();

        for (int i = 0; i<stringLength; i++) {
            if (string0.charAt(i) < string1.charAt(i)) {
                return true;
            } else if (string0.charAt(i) > string1.charAt(i)) {
                break;
            }
        }
        return false;
    }


}
