import java.util.*;

/*
 * Scanner 사용
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long sum = 0;

        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0; i < n; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
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