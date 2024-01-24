import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 인치웜처럼 가서 K만큼 없앴을때 갈수 있는 최대 길이 재기
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[9];
        int total = 0;
        for(int i = 0; i < 9; i++){
            arr[i] = read();
            total += arr[i];
        }

        total -= 100;
        Arrays.sort(arr);

        int s = 0;
        int e = 8;
        while(s < e){
           if(arr[s] + arr[e] == total){
               break;
           }
           else if(arr[s] + arr[e] > total){
               e--;
           }
           else{
               s++;
           }
        }

        for(int i = 0; i < 9; i++){
            if(i == s || i == e) continue;
            System.out.println(arr[i]);
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