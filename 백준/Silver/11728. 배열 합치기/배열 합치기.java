import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 투포인터로 비교해가면서 계산
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        int[] ans = new int[N+M];

        for(int i = 0; i < N; i++){
            arr1[i] = read();
        }

        for(int i = 0; i < M; i++){
            arr2[i] = read();
        }

        StringBuilder sb = new StringBuilder();
        int s = 0;
        int e = 0;
        int p = 0;
        while(p < N+M){
            if(s >= N){
                ans[p++] = arr2[e++];
            }
            else if(e >= M){
                ans[p++] = arr1[s++];
            }
            else if(arr1[s] < arr2[e]){
                ans[p++] = arr1[s++];
            }
            else if(arr1[s] >= arr2[e]){
                ans[p++] = arr2[e++];
            }
        }

        for(int i = 0; i < N+M; i++){
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
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