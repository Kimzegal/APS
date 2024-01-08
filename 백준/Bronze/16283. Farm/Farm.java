/*
 * 세번째 아이디어 : 반복문 최적화
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int a = read();
        int b = read();
        int n = read();
        int w = read();

        int cnt = 0;
        int ans = -1;

        for(int i = 1; i < n; i++){
            if(a*i + b*(n-i) == w) {
                ans = i;
                cnt++;
            }
        }

        if(cnt != 1) System.out.println(-1);
        else System.out.println(ans + " " + (n-ans));
    }
    public static int read() throws Exception{
        int n = 0;
        int cur = 0;
        boolean isNumber = false;
        while(true){
            cur = System.in.read();
            if(cur <= 32){
                if(isNumber){
                    return n;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}