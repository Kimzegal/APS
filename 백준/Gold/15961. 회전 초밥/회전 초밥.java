import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 슬라이딩 윈도우
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int d = read();
        int k = read();
        int c = read();
        int[] arr = new int[N];
        int ans = 0;
        int cur = 0;
        int[] visited = new int[d+1];
        for(int i = 0; i < N; i++){
            arr[i] = read();
            if(i<k) {
                if(visited[arr[i]] == 0) cur++;
                visited[arr[i]]++;
            }
        }

        for(int s = 0; s < N; s++){
            if(visited[c] != 0) ans = Math.max(cur, ans);
            else ans = Math.max(cur +1, ans);
//            System.out.println(cur);
//            System.out.println(Arrays.toString(visited));
            visited[arr[s]]--;
            if(visited[arr[s]] == 0) cur--;

            if(visited[arr[(s + k)%N]] == 0) cur++;
            visited[arr[(s + k)%N]]++;

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