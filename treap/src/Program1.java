import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(new File("src/7.in"));
        File file = new File("src/7.contains2.out");
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);

        int N = console.nextInt();
        int key = console.nextInt();
        Treap newTreap = new Treap(key, ((int)(Math.random()*(2000000000 - 1))));

        System.out.println("-");
        for(int i = 1; i < N; ++i) {
            key = console.nextInt();
            if (!newTreap.Search(key)) {
                newTreap = newTreap.Add(key);
                System.out.println("-");
            } else {
                System.out.println("+");
            }
        }
    }
}
