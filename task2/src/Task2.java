import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        float x = 0;
        float y = 0;
        float rad = 0;

        try (FileReader readerCircle = new FileReader(args[0]);
             Scanner scannerCircle = new Scanner(readerCircle)) {
            while (scannerCircle.hasNextLine()) {
                x = scannerCircle.nextFloat();
                y = scannerCircle.nextFloat();
                rad = scannerCircle.nextFloat();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (FileReader reader = new FileReader(args[1]);
             Scanner console = new Scanner(reader)) {
            while (console.hasNextLine()) {
                float pointX = console.nextFloat();
                float pointY = console.nextFloat();
                double distance = Math.sqrt(((x - pointX) * (x - pointX)) + ((y - pointY) * (y - pointY)));
                if (distance < (double) rad)
                    System.out.println(1);
                else if (distance > (double) rad)
                    System.out.println(2);
                else
                    System.out.println(0);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}