import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String s = String.valueOf(A*B*C);

        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 48]++;
        }

        for(int i = 0; i < 10; i++){
            System.out.println(arr[i]);
        }
    }
}