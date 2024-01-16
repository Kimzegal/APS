import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 두개가 같을경우 빼고는 항상 a,d의 gcd임을 유의하자.
 */
public class Main {
    public static boolean[] seive = new boolean[4000001];
    public static void main(String[] args) throws Exception {

        int A = read();
        int B = read();
        int D = read();
        int cnt = 0;
        seive();

//        for(int i = 1; i < seive.length; i++){
//            if(!seive[i]) System.out.println(i);
//        }

        for(int i = A; i <= B; i++){
            if(seive[i]) continue;
            int now = i;
            while(now != 0){
                int cur = now%10;
                if(cur == D) {
                    cnt++;
                    break;
                }
                now = now/10;
            }
        }

        System.out.println(cnt);
    }
    public static void seive(){
        seive[1] = true;
        for(int i = 2; i <= 2000; i++){
            if(seive[i]) continue;
            for(int j = i * i; j <= 4000000; j+=i ){
                seive[j] = true;
            }
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