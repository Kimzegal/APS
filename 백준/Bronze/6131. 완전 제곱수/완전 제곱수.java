/*
 * 첫번째 아이디어 : 냅다 반복문을 돌린다.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int cnt = 0;

        for (int i = 1; i <= 500; i++) {
            for (int j = i; j <= 500; j++) {
                if(j*j - i*i == N) cnt++;
            }
        }

        System.out.println(cnt);
    }
    public static int read() throws Exception{
        int n = 0;
        int cur;
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