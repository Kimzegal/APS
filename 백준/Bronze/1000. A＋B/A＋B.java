import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int A = System.in.read() - 48; // A 숫자를 받음

        System.in.read(); // 공백제거

        int B = System.in.read() - 48; // B 숫자를 받음

        System.out.println(A+B); // 출력
    }
}