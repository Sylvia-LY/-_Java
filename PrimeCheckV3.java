public class PrimeCheckV3 {

    public static void main(String[] args) {
        boolean[] isPrime = new boolean[300];
        for ( int i = 2; i < isPrime.length; i++ ) {
            isPrime[i] = true;
        }
        for ( int i = 2; i < isPrime.length; i++ ) {
            if ( isPrime[i] ) {
                for ( int k = 2; k*i < isPrime.length; k++ ) {
                    isPrime[k*i] = false;
                }
            }
        }

        for ( int i = 0; i < isPrime.length; i++ ) {
            if ( isPrime[i] ) {
                System.out.print(i+", ");
            }
        }
    }
}
