import java.util.*;
import java.io.*;

/*
 * 빠른 입출력을 받는 버전
 */
public class Main {
    public static void main(String[] args) throws Exception{

        int N = read();
        int[] arr = new int[N];
        int ans = 0;

        for(int i = 0; i < N; i++){
            arr[i] = read();
        }

        Arrays.sort(arr); // 정렬

        System.out.println(arr[(N-1)/2]); // 중앙값 출력
    }

    public static int read() throws Exception{
        int n = 0; // 반환 값
        boolean isNumber = false; // 띄어쓰기가 2개 이상 있는 경우 대비
        while(true){
            int input = System.in.read();
            if(input <= 32) {
                if(isNumber) return n; // 숫자 끝
            }
            else{
                isNumber = true;
                n = (n << 3) + (n << 1) + (input&15); // 자릿수 올리고 input 더하기
            }
        }
    }
}