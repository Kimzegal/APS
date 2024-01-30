import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 단순한 누적합 문제
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n+1];
        int min = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            arr[i] = read();
            arr[i] += arr[i-1];
            ans = Math.max(ans, arr[i] - min);
            if(arr[i] < min) min = arr[i];
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