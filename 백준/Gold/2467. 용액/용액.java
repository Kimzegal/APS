import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 하나로 합친다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);

        int s = 0;
        int e = N-1;


        int ans1 = arr[s];
        int ans2 = arr[e];
        int diff = ans1 + ans2;

        while(s < e){
            int cur = arr[s] + arr[e];
            if(cur == 0){
                System.out.println(arr[s]+" "+arr[e]);
                return;
            }
            else if(cur > 0){
                if(Math.abs(diff) > cur){
                    ans1 = arr[s];
                    ans2 = arr[e];
                    diff = cur;
                }
                e--;
            }
            else{
                if(Math.abs(diff) > -(cur)){
                    ans1 = arr[s];
                    ans2 = arr[e];
                    diff = cur;
                }
                s++;
            }
        }

        System.out.println(ans1 + " " + ans2);
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