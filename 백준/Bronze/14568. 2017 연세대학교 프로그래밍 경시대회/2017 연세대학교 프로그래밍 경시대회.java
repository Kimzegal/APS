/*
 * 첫번째 아이디어 : 냅다 돌리기
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int cnt = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                for (int k = 1; k < N; k++) {
                    if (i + j + k == N && k >= j + 2 && i % 2 == 0) {
                        cnt++;
                    }
                }
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