import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 이차원 누적합을 이용한다
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = read();

        int bad = 0;
        int idx = -1;
        int ans = 0;

        int[] arr = new int[N+1];
        arr[0] = Integer.MIN_VALUE;

        for(int i = 1; i <= N; i++){
            arr[i] = read();
            if(arr[i] < arr[i-1]){
                bad++;
                if(bad > 1) {
                    System.out.println(0);
                    return;
                }
                else idx = i;
            }
        }

        if(bad == 0){
            System.out.println(N);
            return;
        }
        else{
            if(idx == N || arr[idx+1] >= arr[idx-1]) ans++;
            if(arr[idx] >= arr[idx-2]) ans++;
        }

        System.out.println(ans);
//
//        for(int i = 1; i <=N; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }
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