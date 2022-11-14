import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = console.nextInt();
        long m = console.nextInt();
        ArrayList<Long> arrayList = new ArrayList<>();
        long i = 0;
        while (true) {
            long y = (i % n) + 1;
            arrayList.add(y);
            i += m - 1;
            if ((i % n) == 0)
                break;
        }
        System.out.println(arrayList);

    }
}