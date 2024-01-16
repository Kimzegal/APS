import java.util.*;
/*
 * 첫번째 아이디어 : 제곱수면 홀수이므로 깃발의 색이 바뀐다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int ans = 0;
        for(int i = 1; i * i <= N; i++){
            ans++;
        }

        System.out.println(ans);
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
                    return isNegative ? -n : n;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}