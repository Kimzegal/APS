import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 간단한 누적합으 ㅣ차이를 이요한다.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int K = read();
        int ans = Integer.MIN_VALUE;
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = read();
            arr[i] += arr[i-1];
        }
        for(int i = K; i <= N; i++){
            ans = Math.max(ans, arr[i] - arr[i-K]);
        }

        System.out.println(ans);
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