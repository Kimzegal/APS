
import java.util.*;
import java.io.*;

/*
 * BufferedReader 사용
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long sum = 0;

        int n = Integer.parseInt(br.readLine().trim());
        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
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
}