import java.util.*;
/*
 * 첫번째 아이디어 : 점 완전탐색을 한다음, 그 기울기가 서로소인지 판단한다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int C = read();
        StringBuilder sb = new StringBuilder();
        int[] count = new int[1001];

        for(int i = 1; i <= 1000; i++){
            for(int j = 1; j <= 1000; j++){
                int cur = Math.max(i,j);
                if(gcd(i,j) == 1) count[cur]++;
            }
        }

        for(int i = 2; i <= 1000; i++){
            count[i] = count[i] + count[i-1];
        }

        for(int i = 0; i < C; i++){
            sb.append(count[read()]+2).append("\n");
        }

        System.out.println(sb);
    }

    public static int gcd(int a, int b){
        while(a%b != 0){
            int tmp = a%b;
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