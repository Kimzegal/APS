import java.util.*;
/*
 * 첫번째 아이디어 : 두개가 같을경우 빼고는 항상 a,d의 gcd임을 유의하자.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int a = read();
        int d = read();

        int q = read();

        for(int i = 0; i < q; i++){
            int quest = read();
            if(quest == 1){
                long l = read();
                long r = read();
                long start = (l-1)*(2*a + (l-2)*d)/2;
                long end = r*(2*a + (r-1)*d)/2;
                sb.append(end-start).append("\n");
            }
            else{
                long l = read();
                long r = read();
                if(l==r || d==0) sb.append(a + (l-1)*d).append("\n");
                else sb.append(gcd(a,d)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int gcd(int a, int b){
        if(a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        while(a % b !=0){
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