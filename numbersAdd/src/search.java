import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class search {
    public static void binarySearch(int[] xArr, int number) {
        int left = 0;
        int right = xArr.length - 1;
        int middle = (left + right) / 2;

        while (right >= left) {
            if (xArr[middle] < number) {
                left = middle + 1;
            } else if (xArr[middle] == number) {
                System.out.println(middle);
                break;
            } else {
                right = middle - 1;
            }
            middle = (left + right) / 2;
        }
        if (left > right) {
            System.out.println(-1);
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner console = new Scanner(new File("src/5.in"));

        int x_num = console.nextInt();
        int[] x_arr = new int[x_num];
        for(int i = 0; i < x_num; i++) {
            x_arr[i] = console.nextInt();
        }
        int k_num = console.nextInt();
        int[] k_arr = new int[k_num];
        for(int i = 0; i < k_num; i++) {
            k_arr[i] = console.nextInt();
        }

        File file = new File("src/5.out");
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);

        for(int i = 0; i < k_arr.length; i++){
            binarySearch(x_arr, k_arr[i]);
        }
    }

}
