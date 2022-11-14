import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        String argsToArray = args[0];
        int[] array = Arrays.stream(argsToArray.split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        int counter = 0;
        int m = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            int x = Math.abs(array[m] - array[i]);
            counter += x;
        }
        System.out.println(counter);
    }
}