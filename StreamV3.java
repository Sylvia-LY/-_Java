import java.io.*;

public class StreamV3 {
    public static void main(String[] args) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test.txt"))));
            int i = 1999;
            out.println(i);
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/StreamV3.java")));
            String line;
            while ( (line=in.readLine())!=null ) {
                System.out.println(line);
            }

        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
