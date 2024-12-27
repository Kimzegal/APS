import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] arr = new byte[3];
        System.in.read(arr);

        System.out.println(arr[0] - arr[2]);
    }
}