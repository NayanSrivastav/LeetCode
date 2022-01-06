package dp;

public class DivisorGame {

    public static void main(String[] args) {
        DivisorGame driver = new DivisorGame();
        System.out.println(driver.divisorGame(10));
    }

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
