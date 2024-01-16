import java.util.*;
/*
 * 첫번째 아이디어 : 여러개의 최대공약수는 유클리드 호제법을 여러번 써야한다.
 * 따라서, 어느 범위까지의 유클리드 호제법 결과를 가지고 있다면?
 */
public class Main {
    public static int N;
    public static int[] nums;

    public static void main(String[] args) throws Exception {
        N = read();
        nums = new int[N+1];
        for(int i = 1; i <= N; i++){
            nums[i] = read();
        }

        // GCD 연산 결과를 누적해서 가지고 있자
        int[] left = new int[N+2];
        int[] right = new int[N+2];

        for(int i = 1; i <= N; i++){
            left[i] = gcd(left[i-1], nums[i]);
            right[N-i+1] = gcd(right[N-i+2], nums[N-i+1]);
        }

//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        int ans = -1;
        int minus = 0;
        int now = 0;
        for(int i = 1; i <= N; i++){
            now = Math.max(ans, gcd(left[i-1], right[i+1]));
            if(ans != now && nums[i] % now != 0){
                ans = now;
                minus = nums[i];
            }
        }

        if(ans == -1) System.out.println(-1);
        else System.out.println(ans+" "+minus);
    }

    public static int gcd(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }

        return a;
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