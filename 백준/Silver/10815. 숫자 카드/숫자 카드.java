import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 이차원 누적합을 이용한다
 */
public class Main {

    public static int[] have;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder(); // 출력 속도 상승을 위해 선언
        int N = read();
        have = new int[N]; // 상근이가 가진 카드

        for(int i = 0; i < N; i++){
            have[i] = read();
        }

        Arrays.sort(have);

        int M = read();

        for(int i = 0; i < M; i++){
            sb.append(binarySearch(read())).append(" ");
        }

        System.out.println(sb);
    }

    public static int binarySearch(int target){
        int s = 0;
        int e = have.length - 1 ;
        int ans = 0;
        while(s<=e){
            int mid = (s+e)/2; // 중간값
            if(target > have[mid]) {
                s = mid + 1; // 타겟이 더 크면, 중앙값과 그보다 작은 값은 답이 될 수 없다.

            }
            else if(target < have[mid]){
                e = mid - 1; // 반대라면, 중앙값과 그보다 큰 값은 답이 될 수 없다.
            }
            else{
                ans = 1; // 같다면 답이되며, 반복문 종료
                break;
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