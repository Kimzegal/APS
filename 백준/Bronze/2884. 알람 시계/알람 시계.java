import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        now = (now + 1440 - 45)%1440;

        System.out.println(now/60 + " " + now%60);
    }
}