/*
 * 첫번째 아이디어 : 냅다 반복문을 돌린다.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();
        int K = read();

        int max = 0;

        for (int i = 0; i <= K; i++) {
            max = Math.max(max, Math.min((N-i)/2, (M-K+i)));
        }

        System.out.println(max);
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