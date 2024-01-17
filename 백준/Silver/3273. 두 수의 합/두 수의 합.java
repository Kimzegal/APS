import java.util.*;
import java.io.*;

/*
 * 두번째 아이디어 : 범위가 작으므로 카운트배열을 사용해서 정열을 하지 않는다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
       int n = read();
       boolean[] cnt = new boolean[1000002];
       int ans = 0;

       for(int i = 0; i < n ; i++){
           cnt[read()] = true;
       }
       cnt[0] = true;
       cnt[1000001] = true;

       int x = read();
       int s = 1;
       int e = 1000000;
       while(!cnt[s]) s++;

       while(!cnt[e]) e--;

       while(s < e){
           if(s + e > x){
               e--;
               while(!cnt[e]) e--;
           }
           else if(s + e < x){
               s++;
               while(!cnt[s]) s++;
           }
           else{
               ans++;
               s++;
               e--;
               while(!cnt[s]) s++;
               while(!cnt[e]) e--;
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