import java.util.*;
/*
 * 첫번째 아이디어 : 기울기를 이용함
 */
public class Main {
    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();
        int K = read();

        int ans = 0;

        boolean[][][][] visited = new boolean[N+1][M+1][N+1][M+1];

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= M; j++){
                for(int a = i; a <= N; a++){
                    for(int b = 0; b <= M; b++){
                        if(visited[i][j][a][b]) continue;
                        visited[i][j][a][b] = true;
                        int cnt = 1;
                        int startx = i;
                        if(b-j == 0) {

                            if(a-i+1 == K) {
                                // System.out.println(i+"/"+j+","+a+"/"+b);
                                ans++;
                            }
                        }
                        else if(a-i == 0){
                            if(b-j+1 == K) {
                                // System.out.println(i+"/"+j+","+a+"/"+b);
                                ans++;
                            }
                        }
                        else{
                            int plusx = (a-i)/gcd(a-i, Math.abs(b-j));

                            while(startx < a){
                                startx += plusx;
                                cnt++;
                            }
                            if(cnt == K) {
                                // System.out.println(i+"/"+j+","+a+"/"+b);
                                ans++;
                            }
                        }

                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static int gcd(int a, int b){

        while(a % b != 0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return b;
    }
    public static int read() throws Exception{
        int n = 0;
        int cur;
        boolean isNumber = false;
        boolean isNegative = false;
        while(true){
            cur = System.in.read();
            if(cur == '-'){
                isNegative = true;
            }
            else if(cur <= 32){
                if(isNumber){
                    int now = isNegative ? -n : n;
                    return now;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}