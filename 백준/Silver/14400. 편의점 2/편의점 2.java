
import java.util.*;

/*
 * 빠른 입출력 사용 + 카운팅배열
 */
public class Main {

    public static void main(String[] args) throws Exception {

        long sum = 0;

        int n = read();
        int[] x = new int[2000001];
        int[] y = new int[2000001]; // 카운팅 배열 선언

        int[] arrX = new int[n];
        int[] arrY = new int[n]; // 최적화를 위한 그냥 원본배열

        for(int i = 0; i < n; i++){
            int curX = read();
            x[curX + 1000000]++;
            arrX[i] = curX;
            int curY = read();
            y[curY + 1000000]++;
            arrY[i] = curY;
        }

        int medianX = -3000000;
        int medianY = -3000000;
        int cntX = 0;
        int cntY = 0;


        for(int i = 0 ; i < 2000001; i++){
            if(x[i] != 0 && medianX == -3000000){
                cntX += x[i];
                if(cntX >= (n+1)/2) medianX = i-1000000;
            }
            if(y[i] != 0 && medianY == -3000000){
                cntY += y[i];
                if(cntY >= (n+1)/2) medianY = i-1000000;
            }

            if(medianX != -3000000 && medianY != -3000000) break;

        }


        for(int i = 0; i < n; i++){
            int curX = arrX[i] - medianX;
            if(curX < 0) curX = -curX;
            int curY = arrY[i] - medianY;
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