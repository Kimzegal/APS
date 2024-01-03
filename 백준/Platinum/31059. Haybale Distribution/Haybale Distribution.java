
import java.util.*;

/*
 * 첫 아이디어 : 좌우의 갯수로 판단해봅시다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read();
        long[][] cnt = new long[1000001][3];
        int[] arr = new int[N+1];

        if(N == 1) {
            System.out.println(0);
            return;
        }

        for(int i = 1; i <= N; i++){
            int now = read();
            cnt[now][0]++;
            cnt[0][2] += now;
            arr[i] = now;
        }

        Arrays.sort(arr);

        for(int i = 1; i < 1000001; i++){
            cnt[i][0] = cnt[i-1][0] + cnt[i][0];
        }

        for(int i = 1; i < 1000001; i++){
            cnt[i][1] = cnt[i-1][1] + cnt[i-1][0];
            cnt[i][2] = cnt[i-1][2] - (N-cnt[i-1][0]);
        }

//        for(int i = 0; i <= 10; i++){
//            System.out.println(cnt[i][0] + "/" + cnt[i][1] + "/" + cnt[i][2]);
//        }

        int Q = read();

        for(int i = 0; i < Q; i++){
            int a = read();
            int b = read();

            int n = (int)((long)N*b / (a+b));
            if(n < N) n++;
            long sum = cnt[arr[n]][1] * a + cnt[arr[n]][2] * b;

            sb.append(sum).append("\n");

        }

        System.out.println(sb);
    }

    public static int read() throws Exception{
        int n = 0;
        boolean isNumber = false;
        while(true){
            int cur = System.in.read();
            if(cur <= 32){
                if(isNumber){
                    return n;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}