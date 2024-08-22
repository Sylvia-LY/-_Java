import java.io.*;

public class StreamV2 {
    public static void main(String[] args) {
        try {
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("test.dat")));
            // 16进制表示中，只允许0-9，a-f
            int i = 0xcafebabe;
            out.writeInt(i);
            out.close();

            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("test.dat")));
            int j = in.readInt();
            System.out.println(j);

        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
