import java.util.*;
import java.io.*;

/*
 * 나올수 있는 수는 무궁무진하며, 막걸리 수 N와 K숫자도 엄청크다.
 * 완전탐색을 돌린다면, 1~주전자 최대값까지 각 주전자에 대입해서 나눌수 있는 숫자가 K보다 큰지 확인해야한다.
 * 주전자 최대값이 매우 크다면, 이진탐색을 통해서 매개변수탐색을 진행하는 최적화를 사용할 수 있다.
 */
public class Main {
    public static int N, K;
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        N = read(); // 주전사 수
        K = read(); // 학생 수
        int max = 0;
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] =  read();
            max = Math.max(arr[i], max);
        }

        System.out.println(binarySearch(max));
    }

    public static long binarySearch(int bound){
        long s = 1;
        long e = bound;
        long ans = 0;

        while(s<=e) {
            long mid = (s + e) / 2;
            long now = 0;

            for(int i = 0; i < arr.length; i++){
                if(mid != 0) now += arr[i]/mid;
            }

            if(now >= K){
                ans = mid;
                s = mid + 1;
            }

            else{
                e = mid - 1;
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