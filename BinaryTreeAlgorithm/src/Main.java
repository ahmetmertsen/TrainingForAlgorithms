import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashManager manager = new HashManager(10);
        Random random = new Random();
        int value = 0;
        manager.showHashTable();
        for (int i = 0; i < 10000; i++) {
            value = random.nextInt(10000);
            manager.add(value);
        }
        System.out.println(manager.delete(10));
        manager.showHashTable();
        manager.delete(new Scanner(System.in).nextInt());
        System.out.println("------------------------");
        manager.showHashTable();
    }
}