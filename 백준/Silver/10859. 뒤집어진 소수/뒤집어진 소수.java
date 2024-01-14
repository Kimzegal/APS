import java.util.*;
/*
 * 첫번째 아이디어 : 소인수 목록을 미리 구해둔 다음 그걸로 숫자와 뒤집어진 숫자를 나눠서 판단
 */
public class Main {
    public static final int MAX = 100000000;
    public static List<Integer> primes;
    public static int numlen = 0; // 자릿수

    public static void main(String[] args) throws Exception {

        long N = read();
        if(N== 1 || N == -1){
            System.out.println("no");
            return;
        }

        primes = new ArrayList<>();
        boolean[] find = new boolean[MAX+1];

        for(int i = 2; i <= MAX; i++){
            if(find[i]) continue;
            if(i >= 10000) continue;
            for(int j = i*i; j <= MAX; j+=i){
                find[j] = true;
            }
        }

        for(int i = 2; i <= MAX; i++){
            if(!find[i]) primes.add(i);
        }

        if(isPrime(N)){
            long reverse = 0;
            while(N!=0){
                reverse *= 10;
                long now = N%10;
                if(now == 6L) now = 9;
                else if(now == 9L) now = 6;
                reverse += now;
                N /= 10;
            }
            if(isPrime(reverse)) System.out.println("yes");
            else System.out.println("no");
        }
        else System.out.println("no");

    }

    public static boolean isPrime(long now){
        boolean ans = true;
        for(int prime : primes){
            if(prime >= now) break;
            if(now%prime == 0){
                ans = false;
                break;
            }
        }
        return ans;
    }


    public static long read() throws Exception{
        long n = 0;
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
                    long now = isNegative ? -n : n;
                    return now;
                }
            }
            else{
                isNumber = true;
                numlen++;
                if((cur&15) == 3 || (cur&15) == 4 || (cur&15) == 7) return -1;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}