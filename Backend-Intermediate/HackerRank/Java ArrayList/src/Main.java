import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer[]> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int nLines = sc.nextInt(); //5
        sc.nextLine();

        for (int i = 0; i < nLines; i++){
            int aLength = sc.nextInt();
            Integer[] line = new Integer[aLength];
            for (int j = 0; j < aLength; j++){
                line[j] = sc.nextInt();
            }
            list.add(line);
        }
        int query = sc.nextInt();
        for (int i = 0; i < query; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > list.size() || y > list.get(x-1).length){
                System.out.println("ERROR!");
            }
            else{
                System.out.println(list.get(x-1)[y-1]);
            }
        }

    }
}
