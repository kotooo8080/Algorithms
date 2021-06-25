import java.io.*;
import java.util.Scanner;

public class Add {

    public static void complicatedAddition() {
        Scanner console = new Scanner(System.in);

        int num = console.nextInt();
        String rows[] = new String[num * 2];
        for (int i = 0; i < num * 2; i++) {
            rows[i] = console.next();
        }
        int k = 0;
        while (k < num * 2) {
            char[] arr1 = rows[k].toCharArray();
            char[] arr2 = rows[k + 1].toCharArray();

            int[] num1 = new int[arr1.length];
            int[] num2 = new int[arr2.length];

            for (int i = num1.length - 1; i >= 0; i--) {
                num1[num1.length - i - 1] = arr1[i] - '0';
            }
            for (int i = num2.length - 1; i >= 0; i--) {
                num2[num2.length - i - 1] = arr2[i] - '0';
            }
            int[] result = new int[Math.max(num1.length, num2.length) + 1];
            int newDigitRank = 0;
            for (int i = 0; i < result.length; i++) {
                int first = (i < num1.length) ? num1[i] : 0;
                int second = (i < num2.length) ? num2[i] : 0;
                int sum = first + second + newDigitRank;
                if (sum > 9) {
                    newDigitRank = 1;
                    sum %= 10;
                } else newDigitRank = 0;
                result[i] = sum;
            }
            for (int i = 0; i < result.length; i++) {
                if (result[result.length - 1] == 0 && i == 0) {
                    i++;
                }
                System.out.print(result[result.length - i - 1]);
            }
            System.out.println();
            k += 2;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        complicatedAddition();
    }
}









