import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int[] list1 = {22,27,16,2,18,6};
        final int[] list2 = {7,3,5,8,2,9,4,15,6};
        printInsertionSortSteps(list1);
        System.out.println("---------------------------------------");
        printSelectionSortSteps(list2);
    }
    public static void printInsertionSortSteps(int[] list1){
        System.out.println("-----Insertion Sort steps-----");
        System.out.println("Unsorted array: " + Arrays.toString(list1));
        for (int i = 1; i < list1.length; i++) {
            int temp = list1[i];
            int j = i - 1;
            while (j >= 0 && list1[j] > temp) {
                list1[j + 1] = list1[j];
                j = j - 1;
            }
            list1[j + 1] = temp;
                System.out.format("Step %d: ",i);
                System.out.println(Arrays.toString(list1));
        }
        System.out.println("Sorted array: " + Arrays.toString(list1) + " (Big-O: n^2, " + "18: Average case)");
    }
    public static void printSelectionSortSteps(int[] list2){
        System.out.println("-----Selection Sort steps----");
        System.out.println("Unsorted array: " + Arrays.toString(list2));
        for (int i = 0; i < list2.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list2.length; j++) {
                if (list2[j] < list2[minIndex]) {
                    minIndex = j;
                }
            }
                int temp = list2[minIndex];
                list2[minIndex] = list2[i];
                list2[i] = temp;
                if (i <= 4){ //first 4 step.
                    System.out.format("Step %d: ",i);
                    System.out.println(Arrays.toString(list2));
                }else {
                    System.out.format("Step %d: %s",i, "...");
                    System.out.println();
                }
        }
        System.out.println("Sorted array: " + Arrays.toString(list2));
    }
}
