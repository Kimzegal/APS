import java.util.*;
import java.io.*;

/*
 * BufferedReader를 사용한 버전
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 정렬

        System.out.println(arr[(N-1)/2]); // 중앙값 출력
    }
}