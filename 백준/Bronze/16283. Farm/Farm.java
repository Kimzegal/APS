/*
 * 첫번째 아이디어 : 냅다 돌리기
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int a = read();
        int b = read();
        int n = read();
        int w = read();

        int ans1 = -1;
        int ans2 = -1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(a*i + b*j == w && i+j == n) {
                    if(ans1 != -1) {
                        System.out.println(-1);
                        return;
                    }
                    else{
                        ans1 = i;
                        ans2 = j;
                    }
                }
            }
        }

        if(ans1 == -1) System.out.println(-1);

        else System.out.println(ans1 + " " + ans2);
    }
    public static int read() throws Exception{
        int n = 0;
        boolean isNumber = false;
        boolean isNegative = false;
        while(true){
            int cur = System.in.read();
            if(cur == '-'){
                isNegative = true;
            }
            else if(cur <= 32){
                if(isNumber){
                    if(isNegative) return ~n+1;
                    else return n;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}