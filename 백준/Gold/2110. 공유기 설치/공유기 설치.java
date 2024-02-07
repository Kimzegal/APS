import java.util.*;
import java.io.*;

/*
 * 완전탐색을 한다면, 가장 인접한 거리를 1~1000000000까지 탐색해봐야하지만,
 * 이분탐색을 통해 그 수를 줄일 수 있다.
 * 먼저 첫 공유기의 위치를 선정한 이후에, 다음 공유기들을 어디에 설치할지 파악한다.
 */
public class Main {
    public static int N, C;
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        N = read(); // 주전사 수
        C = read(); // 학생 수
        long max = 0;
        long ans = 0;

        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] =  read();
            max = Math.max(arr[i], max);
        }

        Arrays.sort(arr);

            ans = Math.max(ans, binarySearch(max));

        System.out.println(ans);
    }

    public static long binarySearch(long bound){
        long s = 1;
        long e = bound;
        long ans = 0;

        while(s<=e) {
            long mid = (s + e) / 2;
            boolean isOk = false;
            long now = 0;
            long cnt = C-1;
            for(int i = 1; i < arr.length; i++){
                now += arr[i] - arr[i-1];
                if(now >= mid){

                    now = 0;
                    cnt--;
                }
                if(cnt == 0) {
                    isOk = true;
                    break;
                }
            }
            if(isOk){
                ans = Math.max(ans, mid);
                s = mid + 1;
            }
            else{
                e = mid -1;
            }
        }
        return ans;
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