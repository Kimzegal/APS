import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 단순한 누적합 문제
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        int[][] arr = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                arr[i][j] = read();
                arr[i][j] = arr[i][j] + arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1];
            }
        }

        long max = Integer.MIN_VALUE;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                for(int a = 0; a < i; a++){
                    for(int b = 0; b < j; b++){
                        max = Math.max(max, arr[i][j] - arr[a][j] - arr[i][b] + arr[a][b]);
                    }
                }
            }
        }

        System.out.println(max);
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