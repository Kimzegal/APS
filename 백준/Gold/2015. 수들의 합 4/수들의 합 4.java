import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 이차원 누적합을 이용한다
 */
public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new TreeMap<>();
        int N = read();
        int K = read();

        int[] arr = new int[N+1];
        long ans = 0;
        map.put(0,1);

        for(int i = 1; i <= N; i++){
            arr[i] = read() + arr[i-1];
            int get = map.getOrDefault(arr[i]-K, 0);
            ans += get;
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
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