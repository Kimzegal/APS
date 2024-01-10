import java.util.*;
/*
 * 첫번째 아이디어 : 최대값까지 양쪽에서 측정한다
 */
public class Main {

    public static void main(String[] args) throws Exception {
        boolean[] cnt = new boolean[1000001];
        int s = 1000001;
        int e = 0;

        int N = read();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            int cur = read();
            cnt[cur] = true;
            arr[i] = cur;
            s = Math.min(s, cur);
            e = Math.max(e, cur);
        }

        int max = 0;
        for(int i = s; i <= e; i++){
            if(!cnt[i]) continue;
            int seq = 1;
            int prev = arr[0];
            for(int j = 1; j < N; j++){
                if(arr[j]==i) continue;
                if(arr[j] == prev) seq++;
                else{
                    max = Math.max(seq, max);
                    seq = 1;
                    prev = arr[j];
                }
            }
            max = Math.max(seq, max);
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
                    int now = isNegative ? -n : n;
                    return now;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}