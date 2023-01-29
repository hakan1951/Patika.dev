import java.util.ArrayList;
import java.util.Arrays;
//Print repeating even numbers.
public class RepeatingEvenNumbers {
    public static void main(String[] args) {
        int[] list = {3, 7, 3, 3, 2, 9, 10, 21, 1, 33, 9, 1, 2, 4, 0, 0, 0, 0, 6, 4, 12, 12, -16,-16,-16};
        printRepeatingEvenNumbers(list);
    }
    static void printRepeatingEvenNumbers(int[] list) {
        Arrays.sort(list);

        ArrayList<Integer> aList = new ArrayList<>(list.length);
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i : list) {
            aList.add(i);
        }
        for (int i = 0; i < aList.size(); i++){
            if (((aList.get(i) % 2 == 0) && (aList.get(i).equals(aList.get(i+1))) && (!resultList.contains(aList.get(i))))){
                if (i+1 != list.length){
                    if (list[i] == list[i+1]){
                        resultList.add(list[i]);
                    }
                }
            }
        }
        System.out.println(resultList);
    }
    //Without ArrayList(not true if list includes 0's).
    /*
        //The original solution without repeating 0's.
        int[] copyList = new int[list.length];
        int c = 0;
        for (int i = 0; i < list.length; i++){
            if ((list[i] == 0 || (list[i] % 2 == 0)) && !(isInDuplicated(copyList, list[i]))){
                if (i+1 != list.length){
                    if (list[i] == list[i+1]){
                        copyList[c] = list[i];
                        c++;
                    }
                }
            }
        }
        for (int j = 0; j < c; j++) {
                System.out.print(copyList[j] + " ");
        }
    }
    static boolean isInDuplicated(int[] intArray, int aValue){
        for (int i : intArray){
            if (i == aValue){
                return true;
            }
        }
        return false;
    }
    */
}