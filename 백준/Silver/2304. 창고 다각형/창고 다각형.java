import java.util.*;
/*
 * 첫번째 아이디어 : 최대값까지 양쪽에서 측정한다
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int[] plain = new int[1001];
        int N = read();
        int min = 1000;
        int max = 0;
        for(int i = 0; i < N; i++){
            int L = read();
            int H = read();
            plain[L] = H;
            if(L < min) min = L;
            if(L > max) max = L;
        }

        int[] arrH = new int[1001];
        arrH[min] = plain[min];
        for(int i = min+1; i <= max; i++){
            if(arrH[i-1] < plain[i]) arrH[i] = plain[i];
            else arrH[i] = arrH[i-1];
        }

        int[] arrH2 = new int[1001];
        arrH2[max] = plain[max];
        for(int i = max-1; i >= 0; i--){
            if(arrH2[i+1] < plain[i]) arrH2[i] = plain[i];
            else arrH2[i] = arrH2[i+1];
        }

        int total = 0;
        for(int i = min; i <= max; i++){
            total+=Math.min(arrH[i],arrH2[i]);
        }

        System.out.println(total);

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
                    int now = isNegative ? -n : n;
                    return now;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}