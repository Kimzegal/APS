import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] arr = new byte[3]; // 바이트 배열 설정
        System.in.read(arr); // 데이터 읽기

        System.out.println((double)(arr[0]-48) / (double)(arr[2]-48)); // 나누기
    }
}