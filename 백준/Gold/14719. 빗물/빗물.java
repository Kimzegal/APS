import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 앞뒤의 최대값을 구해서 비교한다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int H = read();
        int W = read();
        int[] arr = new int[W+2];
        int[] pre = new int[W+2];
        int[] suf = new int[W+2];
        int ans = 0;
        for(int i = 1; i <= W; i++){
            arr[i] = read();
        }

        for(int i = 1; i <= W; i++){
            pre[i] = Math.max(pre[i-1], arr[i]);
            suf[W-i+1] = Math.max(suf[W-i+2], arr[W-i+1]);
        }

        for(int i = 1; i <= W; i++){
            int now = Math.min(pre[i], suf[i]) - arr[i];
            if(now > 0) ans += now;
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