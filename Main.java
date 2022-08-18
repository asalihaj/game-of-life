import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new GameOfLife();
    }

    public static int getInitialState() {
        return 10 + new Random().nextInt(40);
    }
}
