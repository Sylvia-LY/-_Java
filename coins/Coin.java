import java.util.HashMap;
import java.util.Scanner;

public class Coin {
    private HashMap<Integer, String> coins = new HashMap<>();

    public Coin() {
        coins.put(1, "penny");
        coins.put(5, "nickel");
        coins.put(10, "dime");
        coins.put(25, "quarter");
        coins.put(50, "half dollar");

        System.out.println(coins.keySet().size());
        // 哈希表也有to string
        System.out.println(coins);
        for ( Integer k: coins.keySet() ) {
            System.out.println(k+": "+coins.get(k));
        }

    }

    public String getName(int amount) {
        if ( coins.containsKey(amount) ) {
            return coins.get(amount);
        }
        else {
            return "not found";
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        Coin coin = new Coin();
        String name = coin.getName(amount);
        System.out.println(name);
    }
}
