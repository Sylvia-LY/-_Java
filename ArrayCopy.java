public class ArrayCopy {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new int[a.length];
        for ( int i = 0; i < b.length; i++ ) {
            b[i] = a[i];
        }

        boolean isEqual = true;
        if ( a.length == b.length ) {
            for ( int i = 0; i < a.length; i++ ) {
                if ( a[i] != b[i] ) {
                    isEqual = false;
                    break;
                }
            }

        }

        System.out.println(isEqual);

    }
}
