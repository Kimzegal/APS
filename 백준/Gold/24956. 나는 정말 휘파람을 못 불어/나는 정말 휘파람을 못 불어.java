import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : H를 기준으로, 앞의 W를 세어주고, 뒤의 E를 세어준다.
 * E는 nC0 + ... nCn 에서 nC0 과 nC1을 뺴주면 되므로 2^n - n - 1 이 된다.
 * 시초 : 매번 2^n을 계산하면 H가 많으면 힘들다.
 */
public class Main {
    public static long[] powers;
    public static int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = read();
        String s = br.readLine();
        long ans = 0;
        powers = new long[N+1];
        powers[0] = 1;

        power(N);


        int[] arrW = new int[N+1];
        int[] arrE = new int[N+1];

        for(int i = 1; i <= N; i++){
            if(s.charAt(i-1) == 'W') arrW[i]++;
            arrW[i] += arrW[i-1];

            if(s.charAt(N-i) == 'E') arrE[N-i]++;
            arrE[N-i] += arrE[N-i+1];
        }

        for(int i = 0; i < N; i++){
            if(s.charAt(i) == 'H'){
                ans += ((powers[arrE[i+1]] - arrE[i+1] - 1) * arrW[i]) % MOD;
            }
        }

        System.out.println(ans%MOD);
    }

    public static void power(int n) {
        for(int i = 1; i <= n; i++){
            powers[i] = (powers[i-1] * 2)%MOD;
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