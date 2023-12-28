import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 집의 갯수
        int[] arr = new int[N]; // 집의 위치
        int ans = 0;

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 정렬

        System.out.println(arr[(N-1)/2]); // 중앙값 출력
    }
}