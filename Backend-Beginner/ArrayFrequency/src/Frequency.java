import java.util.ArrayList;
import java.util.Arrays;

public class Frequency {
    public static void main(String[] args) {
        int[] list = {10, 20, 20, 10, 10, 20, 5, 20, 0, 0, 0};
        printFrequency(list);
    }
    static int frequency(int[] list, int number){
        int frequency = 0;
        if (list.length == 0){
            return frequency;
        }
        for (int l : list){
            if (l == number){
                frequency++;
            }
        }
       return frequency;
    }
    static void printFrequency(int[] list){
        Arrays.sort(list);
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int l : list){
            if (!resultList.contains(l)) {
                resultList.add(l);
                int f = frequency(list, l);
                if (f > 0) {
                    System.out.format("Frequency of %d: %d times\n", l, f);
                }
            }
        }
    }
}