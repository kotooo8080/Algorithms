import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class binSearchOnTheRes {
    public static boolean check(int x, int arr[], int k) {  //считаем сколько точек уместится на расстоянии x
        int dots = 0;
        int last_dot = arr[0];
        for (int arr_elem : arr) {
            if (arr_elem - last_dot >= x) {
                dots++;
                last_dot = arr_elem;
            }
        }
        return (dots >= k);
    }
    public static int binSearchRes(int N, int K, int[] NArr) {
        int left = 0;
        int right = (NArr[N - 1] - NArr[0])/K + 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (check(mid, NArr, K)) { //изменяю границы поиска в зависимости от того, что вернет check()
                left = mid;
            } else {
                right = mid;
            }
        }
        return left; //минимальная длина отрезков
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner console = new Scanner(new File("src/3.in"));
        File file = new File("src/3.out");
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);

        int n = console.nextInt();
        int k = console.nextInt();
        int[] nArr = new int[n];
        for(int i = 0; i < n; i++) {
            nArr[i] = console.nextInt();
        }
        int p = binSearchRes(n, k, nArr);
        System.out.print(p);

    }
}

