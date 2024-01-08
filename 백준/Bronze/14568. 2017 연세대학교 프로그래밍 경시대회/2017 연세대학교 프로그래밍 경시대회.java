/*
 * 두번째 아이디어 : 반복문 최적화
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int cnt = 0;

        for (int i = 2; i < N; i+=2) {
            for (int j = 3; j < N-i; j++) {
                if(N-(i+j) <= j - 2) cnt++;
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