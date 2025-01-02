import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        int max = 0;
        for(int i = 0; i < 9; i++){
            int now = Integer.parseInt(br.readLine());
            if(now > max){
                idx = i+1;
                max = now;
            }
        }
        System.out.println(max);
        System.out.println(idx);
    }
}