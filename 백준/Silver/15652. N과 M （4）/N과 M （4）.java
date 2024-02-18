import java.util.*;
import java.io.*;

/*
    기본적인 백트래킹
 */
public class Main {
    public static int N,M;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        N = read(); // 자연수
        M = read(); // 중복없이 고르는 수
        arr = new int[M]; // 수 저장

        permutation(1,0);

        System.out.println(sb);
    }

    public static void permutation(int now, int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n"); // 개행
            return;
        }

        else{
            for(int i = now; i <= N; i++){
                arr[depth] = i;
                permutation(i, depth + 1);
            }
        }
    }


    public static int read() throws Exception{
        int n = 0;
        int cur;
        boolean isNumber = false;
        boolean isNegative = false;
        while(true){
            cur = System.in.read();
            if(cur == '-'){
                isNegative = true;
            }
            else if(cur <= 32){
                if(isNumber){
                    return isNegative ? -n : n;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }

}