
import java.util.*;

/*
 * 빠른 입출력 사용
 */
public class Main {

    public static void main(String[] args) throws Exception {

        long sum = 0;

        int n = read();
        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0; i < n; i++){
            x[i] = read();
            y[i] = read();
        }

        Arrays.sort(x);
        Arrays.sort(y);

        for(int i = 0; i < n; i++){
            int curX = x[i] - x[(n-1)/2];
            if(curX < 0) curX = -curX;
            int curY = y[i] - y[(n-1)/2];
            if(curY < 0) curY = -curY;
            sum += (curX + curY);
        }
        System.out.println(sum);
    }

    public static int read() throws Exception{
        int n = 0;
        boolean isNumber = false;
        boolean minus = false;
        while(true){
            int cur = System.in.read();
            if(cur == '-') minus = true;
            else if(cur <= 32){
                if(isNumber){
                    if(minus) return -n;
                    else return n;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}