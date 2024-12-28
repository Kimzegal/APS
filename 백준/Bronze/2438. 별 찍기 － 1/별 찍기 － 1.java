import java.io.IOException;

/**
 * System.in.read()로 읽고 StringBuilder로 합친 뒤 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        int N = 0;
        int cur = 0;
        while((cur = System.in.read()) >= 48){
            N = (N<<3) + (N<<1) + (cur&15);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.println(sb); 
    }
}