import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int A,B;

        while(true){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            if(A == 0) break;
            B = Integer.parseInt(st.nextToken());
            sb.append(A+B).append("\n");
        }

        System.out.println(sb);
    }
}