import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        int N = read(); int M = read();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = read();
        }

        int sum = 0;
        int max = 0;

        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            for(int j = i+1; j<arr.length; j++){
                if(sum > M) continue;
                sum += arr[j];
                for(int k = j+1; k<arr.length; k++){
                    sum += arr[k];
                    if(sum <= M) max = Math.max(sum, max);
                    sum -= arr[k];
                }
                sum -= arr[j];
            }
            sum -= arr[i];
        }

        System.out.println(max);

    }

    static int read() throws Exception {
        int n = 0;
        boolean isNumber = false;
        while(true) {
            int input = System.in.read();
            if(input <= 32) {
                if(isNumber) return n;
                else continue;
            }
            else {
                isNumber = true;
                n = (n<<3) + (n<<1) + (input&15);
            }
        }
    }
}