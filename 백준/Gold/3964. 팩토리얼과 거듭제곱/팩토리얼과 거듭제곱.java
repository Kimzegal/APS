import java.util.*;
/*
 * 첫번째 아이디어 : 팩토리알 갯수를 센다
 * 이 문제 12퍼센트 틀은 소수를 셀 때 오버플로우(while문)에서 나타나는 것임
 */
public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int T = (int)read();

        for(int i = 0; i < T; i++){
            long n = read();
            long k = read();
            long ans = Long.MAX_VALUE;
            List<long[]> list = getPrime(k);

            for(long[] primes : list){
                // System.out.println(primes[0]+"는"+primes[1]+"개");
                long cnt = 0;
                long cur = n;
                while(cur > 1){
                    cur /= primes[0];
                    cnt += cur;
                }
                //System.out.println(cur);
                ans = Math.min(ans, cnt/primes[1]);

            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static List<long[]> getPrime(long a){
        List<long[]> list = new ArrayList<>();
        long num = a;
        long cnt = 0;
        while(num % 2 == 0){
            num /= 2;
            cnt++;
        }
        if(cnt!=0) list.add(new long[] {2, cnt});

        for(int i = 3; (long)i * i <= a; i+=2){
            cnt = 0;
            while(num % i == 0){
                num /= i;
                cnt++;
            }
            if(cnt!=0) list.add(new long[] {i, cnt});
        }

        if(num != 1) list.add(new long[] {num, 1});
        return list;
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