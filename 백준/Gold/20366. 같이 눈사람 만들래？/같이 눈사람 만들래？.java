import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 두개선택하고 나머지 두개는 투포인터
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = read();
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i==j) continue;
                int s = 0;
                int e = N - 1;
                while(s < e){
                    if(s==i || s==j) s++;
                    else if(e==i || e==j) e--;
                    else{
//                        System.out.println(i+"/"+j+"/"+s+"/"+e);
                        int origin = arr[i] + arr[j];
                        int my = arr[s] + arr[e];
                        ans = Math.min(ans, Math.abs(origin-my));
                        if(origin == my){
                            System.out.println(0);
                            return;
                        }
                        else if(origin < my) e--;
                        else s++;
                    }
                }
            }
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