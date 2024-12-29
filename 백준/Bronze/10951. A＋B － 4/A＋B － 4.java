import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cur;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while((cur = br.readLine()) != null){
            st = new StringTokenizer(cur);
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
        }

        System.out.println(sb);
    }
}