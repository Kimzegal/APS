import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 투포인터로 비교해가면서 계산
 */
public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int G = read();

        int s = 1;
        int e = 1;
        boolean isExist = false;
        while(e < 100001){
            if(e * e - s * s == G){
                isExist = true;
                sb.append(e).append("\n");
                e++;
                s++;
            }
            else if(e * e - s * s > G){
                s++;
            }
            else{
                e++;
            }
        }
        if(isExist) System.out.println(sb);
        else System.out.println(-1);
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