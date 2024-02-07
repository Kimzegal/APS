import java.util.*;
import java.io.*;

/*
 * 결국 100000x100000의 완탐을 최적화 시키는 문제이다.
 * 특정숫자보다 크면 이기고, 같으면 비긴다는 것을 통해 lower, upperbound를 사용한 이진 탐색을 사용할 수 있음을 알 수 있다.
 */
public class Main {
    public static int N, M;
    public static long W, L, D;
    public static int[] arrN, arrM;
    public static void main(String[] args) throws Exception {
        N = read(); // 학생의 수
        M = read(); // 차이의 값
        arrN = new int[N];
        arrM = new int[M];

        for(int i = 0; i < N; i++){
            arrN[i] =  read();
        }

        for(int i = 0; i < M; i++){
            arrM[i] =  read();
        }

        Arrays.sort(arrM);

        for(int i = 0; i < N; i++){
            int draw = lowerbound(arrN[i]);
            int lose = upperbound(arrN[i]);
//            System.out.println(draw + "/" + lose);
//            System.out.print("패배" + (M - lose));
//            System.out.print("무승부" + (lose - draw));
//            System.out.print("승리" + (draw));
//            System.out.println();
            L += M - lose;
            D += lose - draw;
            W += draw;

        }

        System.out.println(W+" "+L+" "+D);
    }

    public static int lowerbound(int target){
        int s = 0;
        int e = arrM.length - 1;
        int ans = arrM.length;

        while(s<=e) {
            int mid = (s + e) / 2;
            if(target > arrM[mid]){
                s = mid + 1;
            }
            else{
                ans = mid;
                e = mid - 1;
            }
        }

        return ans;
    }

    public static int upperbound(int target){
        int s = 0;
        int e = arrM.length - 1;
        int ans = arrM.length;

        while(s<=e) {
            int mid = (s + e) / 2;
            if(target >= arrM[mid]){
                s = mid + 1;
            }
            else{
                ans = mid;
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