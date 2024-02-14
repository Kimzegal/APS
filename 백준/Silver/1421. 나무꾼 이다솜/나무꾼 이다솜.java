import java.util.*;
import java.io.*;

/*
    간단한 완전탐색
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int C = read();
        int W = read();
        int[] arr = new int[N];

        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = read();
            max = Math.max(max, arr[i]);
        }

        long ans = 0;

        for(int i = 1; i <= max; i++){
            long sum = 0;

            for(int j = 0; j < N; j++){
                int cut;
                if(arr[j] % i == 0) cut = (arr[j] / i) - 1;
                else cut = arr[j] / i;

                long cur = (long)W * i *(arr[j]/i) - (long)cut * C;
                if(cur >= 0) sum += cur;
                
            }
            ans = Math.max(ans, sum);
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