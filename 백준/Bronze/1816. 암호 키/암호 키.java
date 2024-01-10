/*
 * 첫번째 아이디어 : 냅다 반복문을 돌린다.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        /*
         입력받기
         */
        int N = (int)read();
        for(int i = 0; i < N; i++){
            long cur = read();
            boolean isOK = true;
            for(int j = 2; j <= 1000000; j++){
                if(cur%j == 0){
                    isOK = false;
                }
            }
            if(isOK) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static long read() throws Exception{
        long n = 0;
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
                    long now = isNegative ? -n : n;
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