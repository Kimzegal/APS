import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 기본적으로 완탐을 돌린다고 가정하자.
 * 1. 임의의 연속된 학번의 학생을 정한다 = 시작점과 끝점을 정한다. N*N
 * 2. 임의로 그룹을 나눈다 = N
 * 이를 모두 하면 시간복잡도는 8,000,000,000 이므로, 약 80초가 걸린다.
 * 여기서 임의의 그룹을 나누는 것을 누적합 배열의 이진탐색으로 logN으로 줄여주는 것이 핵심이다.
 */
public class Main {
    public static int N, E, W;
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        N = read(); // 학생의 수
        E = Integer.MAX_VALUE; // 차이의 값
        arr = new int[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = arr[i-1] + read();
        }

        for(int i = 1; i <= N; i++){
            for(int j = i + 1; j <=N; j++){
                binarySearch(i, j);
            }
        }

        System.out.println(W);
    }

    public static void binarySearch(int start, int end){
        int s = start;
        int e = end;
        while(s<=e) {
            int mid = (s + e) / 2; // 중간값
            if (mid == end) break; // mid == e면, 그룹이 최소한명이라는 가정에 어긋난다.
            int right = arr[end] - arr[mid];
            int left = arr[mid] - arr[start - 1];

            if (right > left) {
                s = mid + 1;
                if (right - left < E) {
                    E = right - left;
                    W = right + left;
                } else if (right - left == E) {
                    W = Math.max(right + left, W);
                }
            } else if (right < left) {
                e = mid - 1;
                if (left - right < E) {
                    E = left - right;
                    W = right + left;
                } else if (left - right == E) {
                    W = Math.max(right + left, W);
                }
            } else {
                if(E==0) W = Math.max(right + left, W);
                else{
                    E = 0;
                    W = right + left;
                }
                break;
            }
//            if(start==2 && end == N-1) {
//                System.out.println(E);
//                System.out.println(right - left);
//                System.out.println(right + "/" + left);
//            }
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