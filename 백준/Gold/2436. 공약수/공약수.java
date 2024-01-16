import java.util.*;
/*
 * 첫번째 아이디어 : 제곱수면 홀수이므로 깃발의 색이 바뀐다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int gcd = read();
        int lcm = read();

        int dist = lcm/gcd;
        int min = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        for(int i = 1; i * i <= dist; i++){
            if(dist%i == 0){
                int small = gcd*i;
                int large = gcd*(dist/i);
                if(min > small + large && gcd(small,large) == gcd){
                    min = small+large;
                    ans1 = small;
                    ans2 = large;
                }
            }
        }

        System.out.println(ans1+" "+ans2);
    }

    public static int gcd(int a, int b){
        while(a % b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
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