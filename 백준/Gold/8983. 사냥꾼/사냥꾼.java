import java.util.*;
import java.io.*;

/*
 * 본래는 사대마다 동물들의 위치를 확인해야 하므로, M x N 즉 최대 10억이다.
 * 이를 최적화하려면 어떻게 해야할까?
 * 방법은, 각 동물마다 M개를 모두계산해 보는 것이아니라 , 범위내를 이진탐색으로 찾는 것이다.
 * 자신을 기준으로 좌측 이진탐색, 우측 이진탐색을 한다면 쉽게 찾을 수 있을 것이다.
 */
public class Main {
    public static int N, M, L;
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        M = read(); // 사대의 수
        N = read(); // 동물의 수
        L = read(); // 사정 거리

        long ans = 0;

        arr = new int[M];
        for(int i = 0; i < M; i++){
            arr[i] = read();
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            int x = read();
            int y = read();
            if(binarySearch(x,y) || binarySearch2(x,y)) {
                ans++;
            }
        }

        System.out.println(ans);

    }

    public static boolean binarySearch(int x, int y){
        int s = 0;
        int e = M-1;
        boolean ans = false;

        while(s<=e) {
            int mid = (s + e) / 2;

            if(arr[mid] < x){
                s = mid + 1;
            }
            else{
                if(arr[mid] - x + y <= L){
                    ans = true;
                    break;
                }
                else{
                    e = mid - 1;
                }
            }
        }
        return ans;
    }

    public static boolean binarySearch2(int x, int y){
        int s = 0;
        int e = M-1;
        boolean ans = false;

        while(s<=e) {
            int mid = (s + e) / 2;

            if(arr[mid] >= x){
                e = mid - 1;
            }
            else{
                if(x - arr[mid] + y <= L){
                    ans = true;
                    break;
                }
                else{
                    s = mid + 1;
                }
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