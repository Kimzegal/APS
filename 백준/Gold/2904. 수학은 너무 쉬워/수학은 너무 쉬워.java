import java.util.*;
/*
 * 첫번째 아이디어 : 소인수의 총 갯수를 구한다음에 나눠본다.
 */
public class Main {
    public static int N;
    public static int bigPrime; // 소인수분해하고 남은 1000 이상의 소수
    public static int[] nums; // 숫자목록
    public static int[][] count; // 소인수 셀것

    public static void main(String[] args) throws Exception {
        N = read();
        if(N == 1){
            System.out.println(read()+" "+0);
            return;
        }
        nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = read();
        }

        count = new int[1001][N+1]; // 소수는 1000까지만 센다. 또한 N번째는 소수의 총 갯수이다.

        // 소인수분해
        getPrime();

        int max = 1; // 총 곱
        int cnt = 0; // 횟수

        for(int i = 2; i < 1001; i++){
            int avr = count[i][N]/N; // 해당 소인수가 분배되어야할 갯수
            if(avr != 0){ // 1개이상 분배될 경우
                for(int j = 0; j < avr; j++){
                    max *= i; // max에 그만큼 곱해줌
                }
                int unbalanced = 0; // avr이랑 현재 숫자가 다른 친구들
                for(int j = 0; j < N; j++){
                    if(count[i][j] < avr) {
                        unbalanced += avr - count[i][j]; // 숫자의 차이만큼
                    }
                }
                cnt += unbalanced; // 한번 움직일때 두개숫자 바뀌므로 2번 나눠줌
            }

        }
        max *= bigPrime; // 만약 1000이상의 소수가
        System.out.println(max+" "+cnt);
    }

    public static void getPrime(){
        for(int i = 0; i < N; i++){
            int cur = nums[i];

            for(int j = 2; j * j <= 1000000; j++){
                while(cur % j == 0){
                    count[j][i]++;
                    count[j][N]++;
                    cur /= j;
                }
            }
            if(bigPrime==0) bigPrime = cur;
            else if(cur != bigPrime) bigPrime = 1;
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