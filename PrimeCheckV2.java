
public class PrimeCheckV2 {
    public static void main(String[] args) {
        int[] primes = new int[50];
        primes[0] = 2;
        int index = 1;
        MAIN_LOOP:
        for ( int x = 3; index < primes.length; x++ ) {
            for ( int i = 0; i < index; i++ ) {
                if ( x % primes[i] == 0 ) {
                    continue MAIN_LOOP;
                }
            }

            primes[index++] = x;
        }
        for ( int k: primes ) {
            System.out.print(k+", ");
        }
    }
}
