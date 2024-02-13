import java.util.*;
import java.io.*;

/*
    간단하게 그냥 set을 이용하자.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = read();
        int C = read();
        char[][] tmp = new char[R][C];
        char[][] arr = new char[C][R];
        Set<String> set = new TreeSet<>(); //중복확인
        String now;
        for(int i = 0; i < R; i++){
            tmp[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                arr[j][i] = tmp[i][j];
            }
        }

        int idx = 0;
        for(int i = 0 ; i < R; i++){
            set = new TreeSet<>();
            for(int j = 0; j < C; j++){
                now = String.valueOf(arr[j], i, R-i);
                if(set.contains(now)){
                    System.out.println(i-1);
                    return;
                }
                else{
                    set.add(now);
                }
            }
        }

        System.out.println(R - 1);

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