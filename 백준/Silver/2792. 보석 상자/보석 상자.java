import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 기본적으로 완탐을 돌린다고 가정하면, 결국 질투심, 즉 가져갈 수 있는 최대의 보석
 * 갯수를 가지고 완전탐색을 할 수 있다.
 * 최대의 보석이 N개라고 가정하면, 이를 분배받을 수 있는 학생의 최저 수는
 * 각 보석마다 N으로 나눈 몫 + N으로 나눈 나머지가 0이 아닐 경우 + 1이다.
 * 즉, 보석색상(M)만큼의 몫/나머지 계산을 최대 보석수(10^9 까지 범위)번 계산을 해야한다.
 * 따라서, 최대 보석수를 이진탐색으로 하여 log단위로 시간 복잡도를 줄여주어 M만큼만 연산한다.
 */
public class Main {
    public static List<Integer> primes = new ArrayList<>();
    public static int N,M;
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        N = read(); // 아이들의 수
        M = read(); // 보석의 수

        arr = new int[M];

        for(int i = 0; i < M; i++){
            arr[i] = read();
        }

        System.out.println(binarySearch());
    }
    
    public static int binarySearch(){
        int s = 1;
        int e = 1000000000;
        int ans = Integer.MAX_VALUE;

        while(s<=e){
            int mid = (s+e)/2; // 중간값
            int cnt = 0;

            for(int i = 0; i < M; i++){
                cnt += arr[i]/mid;
                if(arr[i]%mid != 0) cnt++;
            }

            if(cnt <= N){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
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